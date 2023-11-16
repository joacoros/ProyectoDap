package com.example.tpfinaldap

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.tpfinaldap.viewmodels.SubirSuperHeroViewModel
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class SubirSuperHero : Fragment() {

    companion object {
        fun newInstance() = SubirSuperHero()
    }

    private lateinit var viewModel: SubirSuperHeroViewModel
    private lateinit var textSuperHero: EditText
    private lateinit var textRealName: EditText
    private lateinit var textPublisher: EditText
    private lateinit var textFoto: EditText
    private lateinit var textDescription: EditText
    private var db = Firebase.firestore
    private lateinit var botonSubir: Button

    private lateinit var dataSuperHero: String



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_subir_super_hero, container, false)

        textSuperHero = view.findViewById(R.id.textSuperHero)
        textRealName = view.findViewById(R.id.textRealName)
        textPublisher = view.findViewById(R.id.textPublisher)
        textFoto = view.findViewById(R.id.textFoto)
        textDescription = view.findViewById(R.id.textDescription)
        botonSubir = view.findViewById(R.id.botonSubir)

        botonSubir.setOnClickListener {

            val documentId:String = db.collection("SuperHeroes").document().id

            val superHeroeNuevo = hashMapOf(
                "superhero" to textSuperHero.text.toString(),
                "realName" to textRealName.text.toString(),
                "publisher" to textPublisher.text.toString(),
                "photo" to textFoto.text.toString(),
                "description" to textDescription.text.toString(),
                "idSuperHero" to documentId
            )

            db.collection("SuperHeroes").document(documentId).set(superHeroeNuevo)
                .addOnSuccessListener {
                    Toast.makeText(context, "subido", Toast.LENGTH_SHORT).show()}
                .addOnFailureListener { e ->
                    Toast.makeText(context, "no se pudo subir",Toast.LENGTH_SHORT).show() }

            findNavController().navigate(R.id.action_subirSuperHero_to_pantallaInicio)
        }

        return view
    }

}