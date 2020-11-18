package eco.emergi.embit

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity


/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.button_second).setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }

        //hook in voltage and amperage into UI
        val instantVoltageTextView by lazy {
            view.findViewById<TextView>(R.id.instantVoltage)
        }

        val instantAmperageTextView by lazy {
            view.findViewById<TextView>(R.id.instantAmperage)
        }

        val currVoltage = BatteryInfo.getCurrentVoltage()
        val currAmperage = BatteryInfo.getCurrentAmperage()

        updateTextView(instantVoltageTextView, " " + currVoltage)
        updateTextView(instantAmperageTextView, " " + currAmperage)
    }

    private fun updateTextView(tv: TextView?, str: String) {
        tv?.append(str)
    }
}