package com.example.examencoppel

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.examencoppel.DataRetrofit.HeroeData
import com.example.examencoppel.DataRetrofit.StorageHeroes
import com.google.gson.stream.MalformedJsonException
import kotlinx.coroutines.launch
import retrofit2.Response
import java.net.SocketTimeoutException

class MVVMHeroe() : ViewModel(){

    //var isLoading = false
    var progressB:ProgressBar ?= null
    var page = 0
    val limit = 10
    var isLoading = false
    var contexto:Context ?= null

    lateinit var adaptador: AdaptadorCustom
    lateinit var layoutManager: LinearLayoutManager
    lateinit var recyclerView: RecyclerView


    fun getPage() {
        viewModelScope.launch {
            try {
                isLoading = true
                progressB?.visibility = View.VISIBLE
                val start = ((page) * limit) + 1
                val end = (page + 1) * limit

                var response: Response<HeroeData>

                if (StorageHeroes.Heroes!!.size <= 731) {
                    for (i in start..end) {
                        response = Repository().getHeroe(i.toString())!!

                        if (response.isSuccessful) {
                            Log.e("Jaló #$i", "${response.body().toString()}")

                            if (StorageHeroes.Heroes!!.size < i) {
                                StorageHeroes.Heroes?.add(response.body()!!)
                                Log.e("si escribió", "xd")
                            }

                            Log.e("Tamaño matriz", StorageHeroes.Heroes?.size.toString())
                        } else {
                            Log.e("No Jaló #$i", "Falló")
                        }
                    }
                }

                Handler().postDelayed({
                    if (::adaptador.isInitialized) {
                        adaptador.notifyDataSetChanged()
                    } else {
                        adaptador = AdaptadorCustom(StorageHeroes.Heroes!!, object:ClickListener{
                            override fun onClick(vista: View, index: Int) {
                                //Log.d("MVVM/getPage/onclick", "DISTE CLICK A $index")

                                
                            }
                        })
                        recyclerView.adapter = adaptador
                    }
                    isLoading = false
                    progressB?.visibility = View.GONE
                }, 10000)

            } catch (e: SocketTimeoutException) {
                Log.e("Catch 1", "No se pudo conectar con el servidor")
            } catch (e: MalformedJsonException) {
                Log.e(
                    "Catch 2",
                    "Error al realizar la consulta, verifica la dirección IP del servidor"
                )
            }
        }
    }
}