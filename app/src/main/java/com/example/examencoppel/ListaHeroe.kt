package com.example.examencoppel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.examencoppel.DataRetrofit.HeroeData
import com.example.examencoppel.DataRetrofit.StorageHeroes


class ListaHeroe : Fragment() {

    var lista: RecyclerView? = null
    var adaptador: AdaptadorCustom? = null

    var layoutManager: RecyclerView.LayoutManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_lista_heroe, container, false)
    }

    fun recargar(){
        lista = activity?.findViewById(R.id.RVLista)
        lista?.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(context)
        lista?.layoutManager = layoutManager

        adaptador = AdaptadorCustom(StorageHeroes.Heroes!!)
    }
}