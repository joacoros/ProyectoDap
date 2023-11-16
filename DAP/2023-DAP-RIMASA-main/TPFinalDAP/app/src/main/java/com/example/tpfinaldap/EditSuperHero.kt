package com.example.tpfinaldap

import android.os.Bundle
import android.provider.ContactsContract.DisplayPhoto
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.tpfinaldap.recycleviewclasses.SuperHero
import com.example.tpfinaldap.recycleviewclasses.SuperHeroAdapter
import com.example.tpfinaldap.viewmodels.EditSuperHeroViewModel
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class EditSuperHero : Fragment() {

    private lateinit var viewModel: EditSuperHeroViewModel
    private lateinit var idCompartido: sharedData
    private var db = Firebase.firestore

    private lateinit var superHeroeNuevo: EditText
    private lateinit var realNameNuevo: EditText
    private lateinit var publisherNuevo: EditText
    private lateinit var photoNuevo: EditText
    private lateinit var descriptionNuevo: EditText

    private lateinit var superHeroID: String

    private lateinit var botonSubirDatos: Button


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_edit_super_hero, container, false)

        superHeroeNuevo = view.findViewById(R.id.superheroNuevo)
        realNameNuevo = view.findViewById(R.id.realNameNuevo)
        publisherNuevo = view.findViewById(R.id.publisherNuevo)
        photoNuevo = view.findViewById(R.id.photoNuevo)
        descriptionNuevo = view.findViewById(R.id.descriptionNuevo)

        botonSubirDatos = view.findViewById(R.id.botonSubirDatos)

        db = FirebaseFirestore.getInstance()

        idCompartido = ViewModelProvider(requireActivity()).get(sharedData::class.java)
        idCompartido.dataID.observe(viewLifecycleOwner) { data1 ->

        db.collection("SuperHeroes").document(data1).get().addOnSuccessListener {

            superHeroeNuevo.setText(it.data?.get("superhero").toString())
            realNameNuevo.setText(it.data?.get("realName").toString())
            publisherNuevo.setText(it.data?.get("publisher").toString())
            photoNuevo.setText(it.data?.get("photo").toString())
            descriptionNuevo.setText(it.data?.get("description").toString())
            superHeroID = it.data?.get("idSuperHero").toString()

        }.addOnFailureListener {
            Toast.makeText(context, "no se encontraron datos", Toast.LENGTH_SHORT).show()
        }

        botonSubirDatos.setOnClickListener {

            val superHeroeNuevo = hashMapOf(
                "superhero" to superHeroeNuevo.text.toString(),
                "realName" to realNameNuevo.text.toString(),
                "publisher" to publisherNuevo.text.toString(),
                "photo" to photoNuevo.text.toString(),
                "description" to descriptionNuevo.text.toString(),
                "idSuperHero" to superHeroID
            )

            db.collection("SuperHeroes").document(data1).set(superHeroeNuevo)
                .addOnSuccessListener {
                    Toast.makeText(context, "subido", Toast.LENGTH_SHORT).show()
                }
                .addOnFailureListener { e ->
                    Toast.makeText(context, "no se pudo subir", Toast.LENGTH_SHORT).show()
                }

            findNavController().navigate(R.id.action_editSuperHero_to_pantallaInicio)
        } }

        return view
    }
}