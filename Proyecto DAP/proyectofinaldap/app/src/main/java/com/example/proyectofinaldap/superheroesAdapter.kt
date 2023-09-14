package com.example.proyectofinaldap

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

class superheroesAdapter(

    var superList: MutableList<superheroes>,
    var onClick: (superheroes) -> Unit
    ) : RecyclerView.Adapter<superheroesAdapter.BooksHolder>() {
        class BooksHolder (v: View) : RecyclerView.ViewHolder(v) {
            private var view: View


            init {
                this.view = v
            }

            fun setName (Name : String) {
                var txtName: TextView = view.findViewById(R.id.Nombresup)
                txtName.text = Name
            }

            fun getItem () : ConstraintLayout {
                return view.findViewById(R.id.itemlayout)
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BooksHolder {
            val view =  LayoutInflater.from(parent.context).inflate(R.layout.item_superheroes,parent,false)
            return (BooksHolder(view))
        }

        override fun onBindViewHolder(holder: BooksHolder, position: Int) {
            holder.setName(superList[position].nombre)
            holder.getItem().setOnClickListener {
                print("Click en título")
                onClick(superList[position])
            }
        }

        override fun getItemCount(): Int {
            return superList.size
        }

}