package com.example.recyclerview.adapter

import android.provider.ContactsContract.Contacts.Photo
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recyclerview.R
import com.example.recyclerview.SuperHero

class SuperHeroViewHolder(view: View):RecyclerView.ViewHolder(view) {

    val superHero= view.findViewById<TextView>(R.id.tvSuperheroName)
    val realName= view.findViewById<TextView>(R.id.tvRealName)
    val publisher= view.findViewById<TextView>(R.id.tvPublisher)
    val photo = view.findViewById<ImageView>(R.id.ivSuperHero)
    fun render(superHeroModel: SuperHero){
        superHero.text = superHeroModel.superhero
        realName.text = superHeroModel.realName
        publisher.text = superHeroModel.publisher
        Glide.with(photo.context).load(superHeroModel.photo).into(photo)
        photo.setOnClickListener{
            Toast.makeText(photo.context, superHeroModel.realName, Toast.LENGTH_SHORT).show()
        }
        itemView.setOnClickListener{Toast.makeText(photo.context, superHeroModel.superhero, Toast.LENGTH_SHORT).show()}
    }
}