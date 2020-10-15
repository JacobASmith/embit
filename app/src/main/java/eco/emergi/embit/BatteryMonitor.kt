package eco.emergi.embit

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.BatteryManager
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi

class BatteryMonitor : BroadcastReceiver() {
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onReceive(context: Context, intent: Intent) {

        Log.d("RECEIVED", "BATTERY_PROPERTY_CURRENT_NOW = " + measureAmps(context) + "mA")
        Log.d("RECEIVED", "VOLTAGE =  " + measureVoltage(intent) + "mV")
        Log.d("RECEIVED", "TIME =  " + getTime() + "ms")
    }
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    fun measureAmps(context: Context) : Long? = (context.getSystemService(Context.BATTERY_SERVICE) as BatteryManager?)!!
                                                .getLongProperty(BatteryManager.BATTERY_PROPERTY_CURRENT_NOW)

    fun measureVoltage(intent: Intent) : Int? = intent.extras?.getInt("voltage")
    fun getTime() : Long = System.currentTimeMillis()
    fun storeData(amps: Long, voltage : Int, time : Long ) {

    }
}
