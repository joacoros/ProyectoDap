package com.example.tpfinaldap.recycleviewclasses

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tpfinaldap.R
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class SuperHeroAdapter(
     superHerolist: ArrayList<SuperHero>,
    private val onDeleteClick : (Int)->Unit,
    private val onEditClick : (Int) -> Unit,
     private val onItemClick: (Int) -> Unit

): RecyclerView.Adapter<SuperHeroAdapter.SuperHeroViewHolder>(){
    private var superHerolist: ArrayList<SuperHero>

    init {
        this.superHerolist =superHerolist
    }

    class SuperHeroViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val superHero= view.findViewById<TextView>(R.id.tvSuperheroName)
        val realName= view.findViewById<TextView>(R.id.tvRealName)
        val publisher= view.findViewById<TextView>(R.id.tvPublisher)
        val photo = view.findViewById<ImageView>(R.id.ivSuperHero)
        val editar = view.findViewById<Button>(R.id.botonEditar)
        val eliminar = view.findViewById<Button>(R.id.botonEliminar)

        fun render(superHeroModel: SuperHero){
            superHero.text = superHeroModel.superhero
            realName.text = superHeroModel.realName
            publisher.text = superHeroModel.publisher

            Glide.with(photo.context).load(superHeroModel.photo).into(photo)
            /*photo.setOnClickListener{
                Toast.makeText(photo.context, superHeroModel.realName, Toast.LENGTH_SHORT).show()
            }*/
            //itemView.setOnClickListener{ Toast.makeText(photo.context, superHeroModel.superhero, Toast.LENGTH_SHORT).show()}

        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperHeroViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return SuperHeroViewHolder(layoutInflater.inflate(R.layout.item_superhero, parent, false))
    }
    override fun onBindViewHolder(holder: SuperHeroViewHolder, position: Int) {
        val item = superHerolist[position]
        holder.render(item)
        holder.eliminar.setOnClickListener {
            onDeleteClick(position)
        }
        holder.editar.setOnClickListener {
            onEditClick(position)
        }
        holder.itemView.setOnClickListener {
            onItemClick(position)
        }
        holder.photo.setOnClickListener {
            onItemClick(position)
        }
    }
    override fun getItemCount(): Int = superHerolist.size

}