package com.example.parcial2activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_home_fragmentos.*

class FragmentoHome : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_fragmentos)

        // Cargar fragmento de manera predeterminada 'fragmento de tiempo'
        this.showFragment(FragmentoTiempo())

        //boton home
        home_boton_tiempo.setOnClickListener {
            // Fragmento de Dialog de tiempo
            this.showFragment(name = FragmentoTiempo())
        }

        home_boton_imagen.setOnClickListener {
            // Fragmento de Dialog imagen
            this.showFragment(name = FragmentoImagen())
        }

        home_boton_volver.setOnClickListener {
            // Cerrar
            finish()
        }

    }

    private fun showFragment(name: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.home_container, name, null)
        transaction.commit()
    }
}