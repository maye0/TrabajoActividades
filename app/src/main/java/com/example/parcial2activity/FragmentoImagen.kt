package com.example.parcial2activity

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragmento_imagen.*

class FragmentoImagen : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // inflate Diseño de fragmento
        return inflater.inflate(R.layout.fragmento_imagen, container, false)
    }

    private val images = mapOf<Int, Int>(
        1 to R.drawable.imagen1,
        2 to R.drawable.imagen2,
        3 to R.drawable.imagen3
    )

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        frag_imagen_button.setOnClickListener {

            var numImage = frag_imagen_src.tooltipText.toString().toInt()
            // Contar imagen siguiente
            numImage++

            if (numImage > 3) numImage = 1

            frag_imagen_src.setImageResource(images[numImage]!!)
            frag_imagen_src.tooltipText = numImage.toString()

        }

    }
}