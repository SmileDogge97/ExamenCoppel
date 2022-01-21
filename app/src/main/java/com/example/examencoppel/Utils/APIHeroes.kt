package com.example.examencoppel.Utils

import com.example.examencoppel.DataRetrofit.HeroeData
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import java.util.concurrent.TimeUnit

interface APIHeroes {

    @GET("{id}")
    suspend fun getHeroe(
        @Path("id") id: String
    ): Response<HeroeData>

    companion object {

        operator fun invoke(): APIHeroes {
            val okHttpClient = OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .readTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .build()

            return Retrofit.Builder()
                .baseUrl("https://superheroapi.com/api/1989045744618887/")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(APIHeroes::class.java)
        }
    }
}