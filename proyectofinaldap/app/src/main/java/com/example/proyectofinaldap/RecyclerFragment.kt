package com.example.proyectofinaldap

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecyclerFragment : Fragment() {

    companion object {
        fun newInstance() = RecyclerFragment()
    }

    private lateinit var viewModel: RecyclerFragmentViewmodel
    private lateinit var v : View
    private lateinit var recSuper : RecyclerView
    private var repository = superheroesProvider()
    private lateinit var superList: MutableList<superheroes>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_recycler, container, false)
        recSuper = v.findViewById(R.id.recSups)
        return v
    }

    override fun onStart() {
        super.onStart()

        recSuper.setHasFixedSize(true)

        recSuper.layoutManager  = LinearLayoutManager(context)

        recSuper.adapter = superheroesAdapter(repository.Getsuperhero()){
            superheroes ->
            viewModel.nombre = superheroes.nombre
            viewModel.desc = superheroes.desc
            v?.findNavController()?.navigate(R.id.action_recyclerFragment_to_descripcionFragment)
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(RecyclerFragmentViewmodel::class.java)
        // TODO: Use the ViewModel
    }
}