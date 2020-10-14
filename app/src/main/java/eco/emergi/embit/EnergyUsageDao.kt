package eco.emergi.embit

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Update
import android.arch.persistence.room.Delete

@Dao
interface EnergyUsageDao {

    @Insert
    fun insert(energyUsage: EnergyUsage)

    @Update
    fun update(energyUsage: EnergyUsage)

    @Delete
    fun delete(energyUsage: EnergyUsage)
}