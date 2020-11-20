package eco.emergi.embit

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.BatteryManager
import android.os.Build
import android.os.PowerManager
import android.util.Log
import androidx.annotation.RequiresApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


/**
 * An alarm to monitor and store battery information hourly
 * // ref: https://stackoverflow.com/questions/4459058/alarm-manager-example
 *
 * @author Jacob A. Smith
 *
 * @constructor Creates an instance of the BatteryReceiver with exposed onReceive function
 */
class Alarm : BroadcastReceiver() {
    /**
     * Called hourly by AlarmService.
     *
     * Measures current time, amps, and voltage and calls storeData to place that information in a
     * database
     *
     * @property context The application context the BatteryReceiver is registered to
     * @property intent The Intent carrying the broadcasted message with application information
     */

    @InternalCoroutinesApi
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onReceive(context: Context, intent: Intent) {

        val pm = context.getSystemService(Context.POWER_SERVICE) as PowerManager
        val wl = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "ALARM:")
        wl.acquire()
        Log.d("ALARM", "Alarm triggered at " + getTime())
        storeData(context, measureAmps(context), measureVoltage(intent), getTime())

        wl.release();
    }

    fun setAlarm(context: Context) {
        val am = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val i = Intent(context, Alarm::class.java)
//        val i = Intent("eco.emergi.embit.START_ALARM")
        val pi = PendingIntent.getBroadcast(context, 0, i, 0)
        am.setRepeating(
            AlarmManager.RTC_WAKEUP,
            System.currentTimeMillis(),
            1000 * 60 * 60.toLong(),
            pi
        ) // Millisec * Second * Minute
        // Hourly alarm
    }

    fun cancelAlarm(context: Context) {
        val intent = Intent(context, Alarm::class.java)
        val sender = PendingIntent.getBroadcast(context, 0, intent, 0)
        val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        alarmManager.cancel(sender)
    }



    /**
     * Measure the instantaneous amps the device is using
     *
     * @property context The application context which has access to the system service
     * BatteryManager
     * @return The a Long with current amps in mA
     */
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    private fun measureAmps(context: Context) : Long? =
        (context.getSystemService(Context.BATTERY_SERVICE) as BatteryManager?)!!
            .getLongProperty(BatteryManager.BATTERY_PROPERTY_CURRENT_NOW)

    /**
     * Measure the instantaneous battery voltage
     *
     * @property intent The broadcast intent with the current device voltage
     * @return The device voltage in mV
     */
    private fun measureVoltage(intent: Intent) : Int? = intent.extras?.getInt("voltage")

    /**
     * Get the current unix time in milliseconds
     *
     * @return System's current time in milliseconds as a Long
     */
    private fun getTime() : Long = System.currentTimeMillis()


    /**
     * Insert energyUsage data in the EnergyUsageDatabase in a new coroutine.
     * Log entire database with tag DATABASE
     *
     * @property context The application context where the database will be instantiated
     * @property amps The Long measured value for amps, default to zero if null
     * @property voltage The Int measured value for voltage, default to zero if null
     * @property time The Long value for system time in milliseconds
     */
    @InternalCoroutinesApi
    private fun storeData(context: Context, amps: Long? = 0, voltage: Int? = 0, time: Long) {
        val a = amps ?: 0
        val v = voltage ?: 0
        GlobalScope.launch {
            EnergyUsageDatabase.getInstance(context).energyUsageDao().insert(
                EnergyUsage(amperage = a, voltage = v, time = time)
            )

            val data =
                EnergyUsageDatabase.getInstance(context).energyUsageDao().getAllEnergyUsageData()

            data.collect {
                Log.d("DATABASE", it.toString())
            }
        }

    }
}
