package com.example.examencoppel.Repository

import com.example.examencoppel.Utils.APIHeroes
import com.example.examencoppel.DataRetrofit.HeroeData
import retrofit2.Response

class Repository {

    suspend fun getHeroe(id:String): Response<HeroeData> {
            return APIHeroes().getHeroe(id)
    }

}