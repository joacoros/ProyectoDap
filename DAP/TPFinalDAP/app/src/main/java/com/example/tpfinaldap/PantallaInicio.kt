package com.example.tpfinaldap

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tpfinaldap.viewmodels.PantallaInicioViewModel

class PantallaInicio : Fragment() {

    companion object {
        fun newInstance() = PantallaInicio()
    }

    private lateinit var viewModel: PantallaInicioViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_pantalla_inicio, container, false)

        return view
    }

}