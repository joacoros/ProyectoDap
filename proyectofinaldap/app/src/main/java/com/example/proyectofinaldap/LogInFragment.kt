package com.example.proyectofinaldap

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.google.android.material.snackbar.Snackbar


class LogInFragment : Fragment() {

    companion object {
        fun newInstance() = LogInFragment()
    }

    val sharedViewModel : loginViewmodel by activityViewModels()
    private lateinit var v : View
    private lateinit var userWritten: EditText
    private lateinit var passWritten: EditText
    private lateinit var confirmButton: Button
    private lateinit var signInButton: Button

    @SuppressLint("ResourceType")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_log_in, container, false)
        userWritten = v.findViewById(R.id.editUser)
        passWritten = v.findViewById(R.id.editPass)
        confirmButton = v.findViewById(R.id.loginButton)
        signInButton = v.findViewById(R.id.createUserButton)
        return v
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //viewModel = ViewModelProvider(requireActivity()).get(loginViewmodel::class.java)

        sharedViewModel.usersList.add(usuario("admin", "admin"))

        confirmButton.setOnClickListener {
            val myUser: String = userWritten.text.toString()
            val myPassword: String = passWritten.text.toString()

            var userFound: usuario? = sharedViewModel.usersList.find { u -> u.username == myUser }

            if (userFound != null) {
                if (userFound.password == myPassword) {
                    Snackbar.make(v, "Login successful", Snackbar.LENGTH_SHORT).show()
                    v.findNavController().navigate(R.id.action_logInFragment_to_recyclerFragment)
                } else {
                    Snackbar.make(v, "Username or password incorrect", Snackbar.LENGTH_SHORT).show()
                }
            } else {
                Snackbar.make(v, "Username and password does not exist", Snackbar.LENGTH_SHORT)
                    .show()
            }

            if (myUser.isEmpty() && myPassword.isEmpty()) {
                Snackbar.make(v, "Please insert your Username and Password", Snackbar.LENGTH_SHORT)
                    .show()
            }
        }

        signInButton.setOnClickListener {
            v?.findNavController()?.navigate(R.id.action_logInFragment_to_registerFragment2)
        }
    }
}