package com.example.parcial2activity.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.Toast
import com.example.parcial2activity.R
import kotlinx.android.synthetic.main.dialog_studiantes.*

class StudiantesDialog (context: Context, val callback: (String, String, String, String) -> Unit): Dialog(context) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_studiantes)

        dialog_boton_estudiante.setOnClickListener {
            val cc = dialog_cc_estudiante.text.toString()
            val name = dialog_name_estudiante.text.toString()
            val lastName = dialog_Apell_estudiante.text.toString()
            val phone = dialog_cel_estudiante.text.toString()

            if (cc.isNotEmpty() && name.isNotEmpty() && lastName.isNotEmpty() && phone.isNotEmpty()) {
                callback(cc, name, lastName, phone)
                dismiss()
            } else {
                Toast.makeText(context, R.string.validacion_adicionar_estudiantes, Toast.LENGTH_LONG).show()
            }
        }
    }
}