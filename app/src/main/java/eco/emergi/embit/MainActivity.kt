package eco.emergi.embit

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar


//import eco.emergi.embit.getBatteryStatus

class MainActivity : AppCompatActivity() {
    val db = Room.databaseBuilder(
        applicationContext,
        EnergyUsageDatabase::class.java, "energy_usage_database"
    ).build()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        print("Battery Status: " + getBatteryStatus(this))
        val bm: BatteryMonitor = BatteryMonitor()
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))
        Log.d("created", "MainActivity created")
        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        // Create Database
//        val db = Room.databaseBuilder(
//            applicationContext,
//            EnergyUsageDatabase::class.java, "energy_usage_database"
//            ).build()

        val ifilter = IntentFilter(Intent.ACTION_BATTERY_CHANGED)
        val batteryStatus = applicationContext.registerReceiver(bm, ifilter)
        // From stackoverflow
//        this.registerReceiver(this.BatteryInfo, IntentFilter(Intent.ACTION_BATTERY_CHANGED));

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
    private val BatteryInfo: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(ctxt: Context?, intent: Intent) {
            val level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0)
            val scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, 100)
            val isPresent = intent.getBooleanExtra("present", false)
            val bundle = intent.extras
            val str = bundle.toString()
            Log.i("Battery Info", str)
            if (isPresent) {
                val percent = level * 100 / scale
                Log.d("RECEIVED","Technology: " + bundle!!.getString("technology"))
                Log.d("RECEIVED","Voltage: " + bundle.getInt("voltage") + "mV")
                Log.d("RECEIVED","Temperature: " + bundle.getInt("temperature"))
                Log.d("RECEIVED","Current: " + bundle.getInt("current_avg"))
//                Log.d("RECEIVED","Health: " + getHealthString(health_))
//                Log.d(
//                    "RECEIVED","Charging: " + getStatusString(status) + "(" + getPlugTypeString(
//                        pluggedType
//                    ) + ")"
//                )
                Log.d("RECEIVED","$percent%")
            } else {
                Log.d("RECEIVED","Battery not present!!!")
            }
        }
    }


    private fun getPlugTypeString(plugged: Int): String {
        var plugType = "Unknown"
        when (plugged) {
            BatteryManager.BATTERY_PLUGGED_AC -> plugType = "AC"
            BatteryManager.BATTERY_PLUGGED_USB -> plugType = "USB"
        }
        return plugType
    }

    private fun getHealthString(health: Int): String {
        var healthString = "Unknown"
        when (health) {
            BatteryManager.BATTERY_HEALTH_DEAD -> healthString = "Dead"
            BatteryManager.BATTERY_HEALTH_GOOD -> healthString = "Good Condition"
            BatteryManager.BATTERY_HEALTH_OVER_VOLTAGE -> healthString = "Over Voltage"
            BatteryManager.BATTERY_HEALTH_OVERHEAT -> healthString = "Over Heat"
            BatteryManager.BATTERY_HEALTH_UNSPECIFIED_FAILURE -> healthString = "Failure"
        }
        return healthString
    }

    private fun getStatusString(status: Int): String {
        var statusString = "Unknown"
        when (status) {
            BatteryManager.BATTERY_STATUS_CHARGING -> statusString = "Charging"
            BatteryManager.BATTERY_STATUS_DISCHARGING -> statusString = "Discharging"
            BatteryManager.BATTERY_STATUS_FULL -> statusString = "Full"
            BatteryManager.BATTERY_STATUS_NOT_CHARGING -> statusString = "Not Charging"
        }
        return statusString
    }
}