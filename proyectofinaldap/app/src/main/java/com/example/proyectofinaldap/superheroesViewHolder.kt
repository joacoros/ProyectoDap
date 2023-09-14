package com.example.proyectofinaldap

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class superheroesViewHolder (view:View):RecyclerView.ViewHolder(view) {

    val superheroe = view.findViewById<TextView>(R.id.Nombresup)

    fun render(superheroesmodelo: superheroes){
        superheroe.text = superheroesmodelo.nombre
    }
}