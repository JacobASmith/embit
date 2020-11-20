package eco.emergi.embit

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

// Src: https://stackoverflow.com/questions/4459058/alarm-manager-example
class AutoStart : BroadcastReceiver() {
    var alarm = Alarm()
    override fun onReceive(context: Context, intent: Intent) {
        Log.d("AUTOSTART", "" + intent.action)
        if (intent.action == Intent.ACTION_BOOT_COMPLETED) {
            alarm.setAlarm(context)
        }
    }
}