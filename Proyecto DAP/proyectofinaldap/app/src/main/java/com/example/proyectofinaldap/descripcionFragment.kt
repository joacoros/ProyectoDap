package com.example.proyectofinaldap

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class descripcionFragment : Fragment() {

    companion object {
        fun newInstance() = descripcionFragment()
    }

    private lateinit var viewModel: descripcionViewmodel
    private lateinit var viewModel2 : RecyclerFragmentViewmodel
    private lateinit var v : View
    private lateinit var title : TextView
    private lateinit var description : TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_descripcion, container, false)
        title = v.findViewById(R.id.Nombresup)
        description = v.findViewById(R.id.descriptionsup)
        return v;
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(descripcionViewmodel::class.java)
        viewModel2 = ViewModelProvider(requireActivity()).get(RecyclerFragmentViewmodel::class.java)

        title.text = viewModel2.nombre
        description.text = viewModel2.desc


    }

}