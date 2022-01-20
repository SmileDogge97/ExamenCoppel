package com.example.examencoppel

import com.example.examencoppel.DataRetrofit.HeroeData
import retrofit2.Response

class Repository {

    suspend fun getHeroe(id:String): Response<HeroeData> {
            return APIHeroes().getHeroe(id)
    }

}