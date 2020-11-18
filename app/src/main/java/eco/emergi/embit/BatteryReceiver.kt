package eco.emergi.embit

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.BatteryManager
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.forEach
import kotlinx.coroutines.launch

/**
 * A custom broadcast receiver to monitor and store battery information
 *
 * @author Jacob A. Smith
 *
 * @constructor Creates an instance of the BatteryReceiver with exposed onReceive function
 */
class BatteryReceiver : BroadcastReceiver() {
    /**
     * Called when the registered BatteryReceiver receives an Intent from the application context.
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

        Log.d("RECEIVED", "BATTERY_PROPERTY_CURRENT_NOW = " + measureAmps(context) + "mA")
        Log.d("RECEIVED", "VOLTAGE =  " + measureVoltage(intent) + "mV")
        Log.d("RECEIVED", "TIME =  " + getTime() + "ms")
        storeData(context, measureAmps(context), measureVoltage(intent), getTime())

        BatteryInfo.setCurrentVoltage(measureVoltage(intent))
        BatteryInfo.setCurrentAmperage(measureAmps(context))


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
    private fun storeData(context: Context, amps: Long? = 0, voltage : Int? = 0, time : Long ) {
        val a = amps ?: 0
        val v = voltage ?: 0
        GlobalScope.launch {
            EnergyUsageDatabase.getInstance(context).energyUsageDao().insert(
                EnergyUsage(amperage = a, voltage = v, time = time) )

            val data =
                EnergyUsageDatabase.getInstance(context).energyUsageDao().getAllEnergyUsageData()

            data.collect {
                Log.d("DATABASE", it.toString())
            }
        }

    }
}
