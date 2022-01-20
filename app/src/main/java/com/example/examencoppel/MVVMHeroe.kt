package com.example.examencoppel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.examencoppel.DataRetrofit.HeroeData
import com.example.examencoppel.DataRetrofit.StorageHeroes
import com.google.gson.stream.MalformedJsonException
import kotlinx.coroutines.launch
import retrofit2.Response
import java.net.SocketTimeoutException

class MVVMHeroe() : ViewModel() {

    fun requestsHeroes() {
        viewModelScope.launch {
            try {

                var response: Response<HeroeData>

                for (i: Int in 1..732) {
                    response = Repository().getHeroe(i.toString())!!

                    if (response.isSuccessful) {
                        Log.e("Jaló #$i", "${response.body().toString()}")
                        StorageHeroes.Heroes?.add(response.body()!!)
                        Log.e("Tamaño matriz", StorageHeroes.Heroes?.size.toString())
                    } else {
                        Log.e("No Jaló #$i", "Falló")
                    }

                    if(i==15){
                        ListaHeroe().onRestart()
                    }
                }

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