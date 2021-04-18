package com.example.parcial2activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.parcial2activity.adapter.StudiantesAdapter
import com.example.parcial2activity.data.Estudiants
import com.example.parcial2activity.dialog.StudiantesDialog
import kotlinx.android.synthetic.main.activity_inicio.*

class MainActivity : AppCompatActivity() {

    // lateinit asegura a android que se inicializara mas adelante
    private lateinit var adapter: StudiantesAdapter
    lateinit var students: MutableList<Estudiants>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)

        // Funciones Llamadas
        this.callButtons()
        this.setupList()
    }

    private fun setupList(){
        students = mutableListOf<Estudiants>()

        adapter = StudiantesAdapter(students) { student ->
            val builder = AlertDialog.Builder(this)
            builder.setTitle(getString(R.string.titulo_eliminar_estudiante))
            builder.setMessage(getString(R.string.subtitulo_eliminar_estudiante))
            builder.setPositiveButton(R.string.agregar) { _, _ ->
                this.deleteStudent(student)
            }
            builder.setNegativeButton(getString(R.string.cancelar), null)
            builder.setCancelable(false)
            builder.show()


        }
        ini_rv_estudiantes.adapter = adapter
        ini_rv_estudiantes.layoutManager = LinearLayoutManager(this)
    }


    private fun callButtons() {
        ini_bonton_add.setOnClickListener {
            val dialog = StudiantesDialog(this) { cc, name, lastName, phone ->
                this.addStudent(cc, name, lastName, phone)
            }
            dialog.setCancelable(false)
            dialog.show()
        }

        ini_boton_fragmentos.setOnClickListener {
            val intent = Intent(this, FragmentoHome::class.java)
            startActivity(intent)
        }
    }

    private fun addStudent(cc: String, name: String, lastName: String, phone: String) {
        val student = Estudiants(cc, name, lastName, phone)
        adapter.addStudent(student)
    }

    private fun deleteStudent(student: Estudiants) {
        adapter.deleteStudent(student)
    }

}