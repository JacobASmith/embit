package eco.emergi.embit;

import java.lang.System;

/**
 * A custom broadcast receiver to monitor and store battery information
 *
 * @author Jacob A. Smith
 *
 * @constructor Creates an instance of the BatteryReceiver with exposed onReceive function
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0002J\u0017\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0003\u00a2\u0006\u0002\u0010\bJ\u0017\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002\u00a2\u0006\u0002\u0010\rJ\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0017J5\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0013\u001a\u00020\u0004H\u0003\u00a2\u0006\u0002\u0010\u0014\u00a8\u0006\u0015"}, d2 = {"Leco/emergi/embit/BatteryReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "getTime", "", "measureAmps", "context", "Landroid/content/Context;", "(Landroid/content/Context;)Ljava/lang/Long;", "measureVoltage", "", "intent", "Landroid/content/Intent;", "(Landroid/content/Intent;)Ljava/lang/Integer;", "onReceive", "", "storeData", "amps", "voltage", "time", "(Landroid/content/Context;Ljava/lang/Long;Ljava/lang/Integer;J)V", "app_debug"})
public final class BatteryReceiver extends android.content.BroadcastReceiver {
    
    /**
     * Called when the registered BatteryReceiver receives an Intent from the application context.
     *
     * Measures current time, amps, and voltage and calls storeData to place that information in a
     * database
     *
     * @property context The application context the BatteryReceiver is registered to
     * @property intent The Intent carrying the broadcasted message with application information
     */
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.LOLLIPOP)
    @kotlinx.coroutines.InternalCoroutinesApi()
    @java.lang.Override()
    public void onReceive(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    android.content.Intent intent) {
    }
    
    /**
     * Measure the instantaneous amps the device is using
     *
     * @property context The application context which has access to the system service
     * BatteryManager
     * @return The a Long with current amps in mA
     */
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.LOLLIPOP)
    private final java.lang.Long measureAmps(android.content.Context context) {
        return null;
    }
    
    /**
     * Measure the instantaneous battery voltage
     *
     * @property intent The broadcast intent with the current device voltage
     * @return The device voltage in mV
     */
    private final java.lang.Integer measureVoltage(android.content.Intent intent) {
        return null;
    }
    
    /**
     * Get the current unix time in milliseconds
     *
     * @return System's current time in milliseconds as a Long
     */
    private final long getTime() {
        return 0L;
    }
    
    /**
     * Insert energyUsage data in the EnergyUsageDatabase in a new coroutine.
     * Log entire database with tag DATABASE
     *
     * @property context The application context where the database will be instantiated
     * @property amps The Long measured value for amps, default to zero if null
     * @property voltage The Int measured value for voltage, default to zero if null
     * @property time The Long value for system time in milliseconds
     */
    @kotlinx.coroutines.InternalCoroutinesApi()
    private final void storeData(android.content.Context context, java.lang.Long amps, java.lang.Integer voltage, long time) {
    }
    
    public BatteryReceiver() {
        super();
    }
}