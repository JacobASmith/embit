package eco.emergi.embit

import android.content.Context
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteOpenHelper

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

        fun getInstance(context: Context): EnergyUsageDatabase{
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        EnergyUsageDatabase::class.java,
                        "energy_usage_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}