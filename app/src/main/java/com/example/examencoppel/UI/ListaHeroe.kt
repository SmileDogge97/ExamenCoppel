package com.example.examencoppel.UI

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.examencoppel.*
import com.example.examencoppel.MVVM.MVVMHeroe
import com.example.examencoppel.Utils.AdaptadorCustom
import com.example.examencoppel.Utils.SenalNavigation
import com.example.examencoppel.Utils.ValidarR
import com.example.examencoppel.databinding.FragmentListaHeroeBinding


class ListaHeroe : Fragment(), SenalNavigation {

    //var lista: RecyclerView? = null
    var adaptador: AdaptadorCustom?= null
    lateinit var layoutManager: LinearLayoutManager
    lateinit var listaViewModel: MVVMHeroe
    var vista: View ?= null


    private var _binding:FragmentListaHeroeBinding ?= null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //return inflater.inflate(R.layout.fragment_lista_heroe, container, false)
        Log.d("ListaHeroe", "onCreateView")

        _binding = FragmentListaHeroeBinding.inflate(inflater, container, false)
        val view = binding.root
        return view

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        Log.d("ListaHeroe", "onActivityCreated")

        listaViewModel = ViewModelProviders.of(this).get(MVVMHeroe::class.java)
        layoutManager = LinearLayoutManager(this.context)
        binding?.RVLista!!.layoutManager = layoutManager
        listaViewModel.progressB = binding?.ProgressB
        listaViewModel.recyclerView = binding?.RVLista!!
        listaViewModel.contexto = activity?.applicationContext
        listaViewModel.senal= this

        startRequest()


        binding?.RVLista!!.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {

//                if (dy > 0) {
                val visibleItemCount = layoutManager.childCount
                val pastVisibleItem = layoutManager.findFirstCompletelyVisibleItemPosition()
                //val total = adaptador?.itemCount
                val total = listaViewModel.adaptador.itemCount

                if (!listaViewModel.isLoading) {

                    if ((visibleItemCount + pastVisibleItem) >= total) {
                        listaViewModel.page++
                        startRequest()
                        //listaViewModel.getPage()
                    }

                }
//                }

                super.onScrolled(recyclerView, dx, dy)
            }
        })


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.d("ListaHeroe", "onViewCreated")

        this.vista = view
        /*binding.button2.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.detalles)
        }*/
    }

    fun startRequest() {
        if (ValidarR.hayRed(context as AppCompatActivity)) {
            //loginViewModel.requestsHeroes()
            binding.textView13.visibility = View.GONE
            listaViewModel.getPage()
        } else {
            binding.ProgressB.visibility = View.GONE
            binding.textView13.visibility = View.VISIBLE

            val builder = AlertDialog.Builder(context as AppCompatActivity)
            builder.setMessage("No hay red")
            builder.setPositiveButton("ok") { dialog, id -> }
            builder.show()
        }
    }

    override fun pasarADetalles() {
        vista?.let { Navigation.findNavController(it).navigate(R.id.detalles) }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("ListaHeroes", "onAttach")
        //StorageHeroes.restart()
    }

}