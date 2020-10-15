package eco.emergi.embit

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import android.content.Context

@Database(entities = arrayOf(EnergyUsage::class), version = 1)
abstract class EnergyUsageDatabase : RoomDatabase() {
    abstract fun energyUsageDao(): EnergyUsageDao

//    val db = Room.databaseBuilder(
//            applicationContext,
//            EnergyUsageDatabase::class.java, "energy_usage_database"
//    ).build()
}