package com.example.tpfinaldap

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.tpfinaldap.viewmodels.DataSuperHeroesViewModel
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class DataSuperHeroes : Fragment() {

    private lateinit var viewModel: DataSuperHeroesViewModel
    private lateinit var idCompartido: sharedData
    private var db = Firebase.firestore

    private lateinit var superHeroeData: TextView
    private lateinit var realNameData: TextView
    private lateinit var publisherData: TextView
    private lateinit var photoData: ImageView
    private lateinit var descriptionData: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_data_super_heroes, container, false)

        superHeroeData = view.findViewById(R.id.superheroData)
        realNameData = view.findViewById(R.id.realNameData)
        publisherData = view.findViewById(R.id.publisherData)
        photoData = view.findViewById(R.id.photoData)
        descriptionData = view.findViewById(R.id.descriptionData)

        db = FirebaseFirestore.getInstance()

        idCompartido = ViewModelProvider(requireActivity()).get(sharedData::class.java)
        idCompartido.dataID.observe(viewLifecycleOwner) { data1 ->

            db.collection("SuperHeroes").document(data1).get().addOnSuccessListener {

                superHeroeData.text = (it.data?.get("superhero").toString())
                realNameData.text = (it.data?.get("realName").toString())
                publisherData.text = (it.data?.get("publisher").toString())
                Glide.with(photoData.context).load(it.data?.get("photo").toString()).into(photoData)
                descriptionData.text = (it.data?.get("description").toString())

            }.addOnFailureListener {
                Toast.makeText(context, "no se encontraron datos", Toast.LENGTH_SHORT).show()
            }
        }
        return view
    }

}