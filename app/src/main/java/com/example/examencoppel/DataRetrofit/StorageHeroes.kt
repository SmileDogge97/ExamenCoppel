package com.example.examencoppel.DataRetrofit

import android.util.Log

object StorageHeroes {
     var position:Int ?= null
     var Heroes:ArrayList<HeroeData>? = arrayListOf()

     fun restart(){
          Log.d("StorageHeroes", "restart")
          Heroes = arrayListOf()
     }
}