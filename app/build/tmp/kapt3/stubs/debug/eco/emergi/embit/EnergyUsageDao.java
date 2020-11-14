package eco.emergi.embit;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J \u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bH\'J\u0014\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u000e0\rH\'J \u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bH\'J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'\u00a8\u0006\u0012"}, d2 = {"Leco/emergi/embit/EnergyUsageDao;", "", "delete", "", "energyUsage", "Leco/emergi/embit/EnergyUsage;", "deleteEnergyUsage", "amps", "", "volts", "", "time", "getAllEnergyUsageData", "Lkotlinx/coroutines/flow/Flow;", "", "getEnergyUsage", "insert", "update", "app_debug"})
public abstract interface EnergyUsageDao {
    
    @androidx.room.Insert()
    public abstract void insert(@org.jetbrains.annotations.NotNull()
    eco.emergi.embit.EnergyUsage energyUsage);
    
    @androidx.room.Update()
    public abstract void update(@org.jetbrains.annotations.NotNull()
    eco.emergi.embit.EnergyUsage energyUsage);
    
    @androidx.room.Delete()
    public abstract void delete(@org.jetbrains.annotations.NotNull()
    eco.emergi.embit.EnergyUsage energyUsage);
    
    @androidx.room.Query(value = "DELETE FROM energyusage WHERE amperage=:amps AND voltage=:volts AND time=:time")
    public abstract void deleteEnergyUsage(long amps, int volts, long time);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM energyusage WHERE amperage=:amps AND voltage=:volts AND time=:time")
    public abstract eco.emergi.embit.EnergyUsage getEnergyUsage(long amps, int volts, long time);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM energyusage")
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<eco.emergi.embit.EnergyUsage>> getAllEnergyUsageData();
}