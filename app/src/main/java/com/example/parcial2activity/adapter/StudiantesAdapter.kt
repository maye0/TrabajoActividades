package com.example.parcial2activity.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.parcial2activity.R
import com.example.parcial2activity.data.Estudiants
import kotlinx.android.synthetic.main.studiantes_item.view.*

class StudiantesAdapter (private val students: MutableList<Estudiants>, private val callback: (Estudiants) -> Unit): RecyclerView.Adapter<StudiantesAdapter.StudentViewHolder>() {

    class StudentViewHolder(itemView: View, val callback: (Estudiants) -> Unit): RecyclerView.ViewHolder(itemView) {
        fun bind(student: Estudiants) {
            itemView.cc_estudiante.text = student.cedula
            itemView.nombre_estudiante.text = student.nombre
            itemView.Apellido_Estudiante.text = student.apellido
            itemView.Celular_Estudiante.text = student.celular
            itemView.borrar_estudiante.setOnClickListener {
                callback(student)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.studiantes_item, parent, false)
        return StudentViewHolder(view, callback)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.bind(students[position])
    }

    override fun getItemCount(): Int {
        return students.size
    }

    fun addStudent(student: Estudiants) {
        students.add(student)
        notifyDataSetChanged()
    }

    fun deleteStudent(student: Estudiants) {
        students.remove(student)
        notifyDataSetChanged()
    }
}