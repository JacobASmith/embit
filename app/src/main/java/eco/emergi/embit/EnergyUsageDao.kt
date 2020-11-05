package eco.emergi.embit

import androidx.room.*
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

@Dao
interface EnergyUsageDao {

    @Insert
    fun insert(energyUsage: EnergyUsage)

    @Update
    fun update(energyUsage: EnergyUsage)

    @Delete
    fun delete(energyUsage: EnergyUsage)

    @Query("DELETE FROM energyusage WHERE amperage=:amps AND voltage=:volts AND time=:time")
    fun deleteEnergyUsage(amps: Long, volts: Int, time: Long)

    @Query("SELECT * FROM energyusage WHERE amperage=:amps AND voltage=:volts AND time=:time")
    fun getEnergyUsage(amps: Long, volts: Int, time: Long): EnergyUsage

    @Query( "SELECT * FROM energyusage")
    fun getAllEnergyUsageData(): Flow<List<EnergyUsage>>

}