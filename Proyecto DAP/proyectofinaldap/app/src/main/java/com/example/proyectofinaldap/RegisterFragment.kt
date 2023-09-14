package com.example.proyectofinaldap

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.google.android.material.snackbar.Snackbar

class RegisterFragment : Fragment() {
    companion object {
        fun newInstance() = CrearUsuarioViewModel()
    }

    private lateinit var viewModelSignIn: CrearUsuarioViewModel
    private lateinit var viewModelLogin : loginViewmodel
    private lateinit var v : View
    private lateinit var username: EditText
    private lateinit var password: EditText
    private lateinit var createButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_register, container, false)
        username = v.findViewById(R.id.createUsername)
        password = v.findViewById(R.id.createPassword)
        createButton = v.findViewById(R.id.createButton)
        return v;
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModelSignIn = ViewModelProvider(requireActivity()).get(CrearUsuarioViewModel::class.java)
        viewModelLogin = ViewModelProvider(requireActivity()).get(loginViewmodel::class.java)

        createButton.setOnClickListener {
            val newUser: String = username.text.toString()
            val newPass: String = password.text.toString()

            print(newUser)
            print(newPass)
            var userExists: usuario? = viewModelLogin.usersList.find { u -> u.username == newUser }
            //INCLUSO SI COMENTO TODO Y ESTA LISTA QUEDA DESCOMENTADA SE CIERRA
            if (newUser.isEmpty() || newPass.isEmpty()) {
                Snackbar.make(v, "Please insert your Username and Password", Snackbar.LENGTH_SHORT).show()
            }
            else if (userExists != null) {
                Snackbar.make(v, "That username already exists", Snackbar.LENGTH_SHORT).show()
            }
            else {
                viewModelLogin.usersList.add(usuario(newUser, newPass))
                //LO QUE ESTA PASANDO CREO QUE ES QUE NO RECONOCE LAS VARIABLES COMO STRINGS
                Snackbar.make(v, "User created", Snackbar.LENGTH_SHORT).show()
                print("user created")
                view?.findNavController()?.navigate(R.id.action_registerFragment_to_logInFragment)
            }
        }
    }

}