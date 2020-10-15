package eco.emergi.embit

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
class EnergyUsage {

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
    var usage: Int = 0

}