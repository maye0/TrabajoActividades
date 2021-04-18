package com.example.parcial2activity

import android.app.TimePickerDialog
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import java.time.LocalTime
import kotlinx.android.synthetic.main.fragmento_tiempo.*

class FragmentoTiempo : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate Diseño del Fragmento
        return inflater.inflate(R.layout.fragmento_tiempo, container, false)
    }

    var hour = 0
    var minute = 0

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //reloj de tiempo
        frag_tiempo_button.setOnClickListener {
            val dialog = TimePickerDialog(requireContext(),{ _, hours, minutes ->
                hour = hours
                minute = minutes
                val time = LocalTime.of(hours, minutes)
                frag_tiempo_value.text = time.toString()
            },hour, minute,false)
            dialog.show()
        }

    }
}