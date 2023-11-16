package com.example.tpfinaldap

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.tpfinaldap.viewmodels.PantallaLoginViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class PantallaLogin : Fragment() {

    private lateinit var viewModel: PantallaLoginViewModel

    lateinit var botonLogin: Button
    lateinit var botonRegistrar: Button
    lateinit var mail: EditText
    lateinit var pass: EditText
    lateinit var textoMail: String
    lateinit var textoPass: String
    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_pantalla_login, container, false)

        botonRegistrar = view.findViewById(R.id.buttonRegistrar)
        botonLogin = view.findViewById(R.id.botonLogin)
        mail = view.findViewById(R.id.textoUsuario)
        pass = view.findViewById(R.id.textoContra)
        auth = Firebase.auth

        botonRegistrar.setOnClickListener {
            findNavController().navigate(R.id.action_pantallaLogin_to_pantallaRegister)
        }

        botonLogin.setOnClickListener {
            textoMail = mail.text.toString()
            textoPass = pass.text.toString()

            auth.signInWithEmailAndPassword(textoMail, textoPass).addOnCompleteListener { }
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Log.d(ContentValues.TAG, "signInWithEmail:success")
                        val user = auth.currentUser
                        findNavController().navigate(R.id.action_pantallaLogin_to_pantallaInicio)
                    } else {
                        Log.w(ContentValues.TAG, "signInWithEmail:failure", task.exception)
                        Toast.makeText(context, "El mail y/o contraseña ingresados son incorrectos", Toast.LENGTH_SHORT,).show()
                    } } }
        return view
    } }