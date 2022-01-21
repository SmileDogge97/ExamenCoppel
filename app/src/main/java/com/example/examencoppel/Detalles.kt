package com.example.examencoppel

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.examencoppel.DataRetrofit.HeroeData
import com.example.examencoppel.DataRetrofit.StorageHeroes
import com.example.examencoppel.databinding.FragmentDetallesBinding
import com.example.examencoppel.databinding.FragmentListaHeroeBinding


class Detalles : Fragment() {

    private var _binding: FragmentDetallesBinding? = null
    private val binding get() = _binding
    var index:Int ?= null
    var datos:ArrayList<HeroeData> ?= null
    var alias:String ?= ""


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_detalles, container, false)

        _binding = FragmentDetallesBinding.inflate(inflater, container, false)
        val view = binding?.root
        return view

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        index = StorageHeroes.position
        Log.d("Detalles/index", index.toString())
        datos = StorageHeroes.Heroes

        colectarAlias()

        binding?.TVInteligencia?.text = datos?.get(index!!)?.powerstats?.intelligence
        binding?.TVFuerza?.text = datos?.get(index!!)?.powerstats?.strength
        binding?.TVVelocidad?.text = datos?.get(index!!)?.powerstats?.speed
        binding?.TVDurabilidad?.text = datos?.get(index!!)?.powerstats?.durability
        binding?.TVPoder?.text = datos?.get(index!!)?.powerstats?.power
        binding?.TVCombate?.text = datos?.get(index!!)?.powerstats?.combat

        /*binding!!.TVNombreCompleto.text = datos?.get(index!!)?.biography?.fullName
        binding!!.TVAlterEgos.text = datos?.get(index!!)?.biography?.alterEgos*/
        binding!!.TVAliases.text = alias
        /*binding!!.TVLugarNacimiento.text = datos?.get(index!!)?.biography?.placeOfBirth
        binding!!.TVPrimeraAparicion.text = datos?.get(index!!)?.biography?.firstAppearance*/
        binding!!.TVEditorial.text = datos?.get(index!!)?.biography?.publisher
        binding!!.TVAlineamiento.text = datos?.get(index!!)?.biography?.alignment

        binding!!.TVGenero.text = datos?.get(index!!)?.appearance?.gender
        binding!!.TVRaza.text = datos?.get(index!!)?.appearance?.race
        binding!!.TVTamaO.text = datos?.get(index!!)?.appearance?.weight.toString()
        binding!!.TVPeso.text = datos?.get(index!!)?.appearance?.height.toString()
        /*binding!!.TVColorOjos.text = datos?.get(index!!)?.appearance?.eyeColor
        binding!!.TVColorCabello.text = datos?.get(index!!)?.appearance?.hairColor*/

        binding!!.TVOcupacion.text = datos?.get(index!!)?.work?.occupation
        binding!!.TVBase.text = datos?.get(index!!)?.work?.base

        //binding!!.TVGrupoAfiliado.text = datos?.get(index!!)?.connections?.groupAffiliation
        binding!!.TVRelaciones.text = datos?.get(index!!)?.connections?.relatives
    }

    fun colectarAlias() {
        for (i: Int in 0..(datos!!.get(index!!).biography.aliases.size-1)){
            alias += datos!!.get(index!!).biography.aliases.get(i)
        }
    }

}