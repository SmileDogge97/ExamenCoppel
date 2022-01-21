package com.example.examencoppel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.examencoppel.databinding.FragmentDetallesBinding
import com.example.examencoppel.databinding.FragmentListaHeroeBinding


class Detalles : Fragment() {

    private var _binding: FragmentDetallesBinding?= null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_detalles, container, false)

        _binding = FragmentDetallesBinding.inflate(inflater, container, false)
        val view = binding.root
        return view

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


    }


}