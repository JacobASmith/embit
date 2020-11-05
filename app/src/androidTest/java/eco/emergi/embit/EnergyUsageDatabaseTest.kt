package eco.emergi.embit

import android.util.Log
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class EnergyUsageDatabaseTest {
    private var energyUsageDao: EnergyUsageDao? = null
    @Before
    fun setup() {
        EnergyUsageDatabase.TEST_MODE = true
        energyUsageDao = EnergyUsageDatabase.getInstance(InstrumentationRegistry.getInstrumentation().targetContext).energyUsageDao()

    }

    @Test
    fun insertTest() {
        GlobalScope.launch {
            var time = System.currentTimeMillis()
            var energyUsage = EnergyUsage(amperage = 1, voltage = 1, time = time)
            energyUsageDao?.insert(energyUsage)
            var energyUsageTest : EnergyUsage = EnergyUsage(amperage = 0, voltage = 0, time = 0)
            energyUsageDao?.getAllEnergyUsageData()?.collect {
                energyUsageTest = it[0]
            }
            assertEquals(energyUsage, energyUsageTest)
        }

    }

    @Test
    fun deleteEnergyUsageTest() {
        var time = System.currentTimeMillis()
        var energyUsage = EnergyUsage(amperage = 2, voltage = 2, time = time)
        energyUsageDao?.insert(energyUsage)
        energyUsageDao?.deleteEnergyUsage(energyUsage.amperage, energyUsage.voltage, energyUsage.time)
        assertNull(energyUsageDao?.getEnergyUsage(energyUsage.amperage, energyUsage.voltage, energyUsage.time))
    }
//    @Test
//    fun storeDataTest() {
//        // Context of the app under test.
//        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
//        assertEquals("eco.emergi.embit", appContext.packageName)
//    }
}