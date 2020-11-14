package eco.emergi.embit;

import java.lang.System;

@androidx.room.Database(entities = {eco.emergi.embit.EnergyUsage.class}, version = 1)
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&\u00a8\u0006\u0006"}, d2 = {"Leco/emergi/embit/EnergyUsageDatabase;", "Landroidx/room/RoomDatabase;", "()V", "energyUsageDao", "Leco/emergi/embit/EnergyUsageDao;", "Companion", "app_debug"})
public abstract class EnergyUsageDatabase extends androidx.room.RoomDatabase {
    private static boolean TEST_MODE = false;
    private static volatile eco.emergi.embit.EnergyUsageDatabase INSTANCE;
    public static final eco.emergi.embit.EnergyUsageDatabase.Companion Companion = null;
    
    @org.jetbrains.annotations.NotNull()
    public abstract eco.emergi.embit.EnergyUsageDao energyUsageDao();
    
    public EnergyUsageDatabase() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n\u00a8\u0006\u000e"}, d2 = {"Leco/emergi/embit/EnergyUsageDatabase$Companion;", "", "()V", "INSTANCE", "Leco/emergi/embit/EnergyUsageDatabase;", "TEST_MODE", "", "getTEST_MODE", "()Z", "setTEST_MODE", "(Z)V", "getInstance", "context", "Landroid/content/Context;", "app_debug"})
    public static final class Companion {
        
        public final boolean getTEST_MODE() {
            return false;
        }
        
        public final void setTEST_MODE(boolean p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final eco.emergi.embit.EnergyUsageDatabase getInstance(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}