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

    companion object {
        @Volatile
        private var INSTANCE: EnergyUsageDatabase? = null

        fun getDatabase(applicationContext: Context): EnergyUsageDatabase{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            } else {
                val instance = Room.databaseBuilder(
                    applicationContext,
                    EnergyUsageDatabase::class.java,
                    name: "energy_usage_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}