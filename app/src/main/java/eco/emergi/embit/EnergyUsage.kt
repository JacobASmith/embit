package eco.emergi.embit

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class EnergyUsage(
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    var amperage: Long,
    var voltage: Int,
    var time: Long
)