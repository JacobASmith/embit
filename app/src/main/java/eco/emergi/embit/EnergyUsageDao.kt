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

    @Query( "SELECT * FROM energyusage")
    fun getAllEnergyUsageData(): Flow<List<EnergyUsage>>

}