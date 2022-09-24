package com.example.rajpathbookreaderapp.ConstantAPI

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory



object ApiClient {
    private const val BASE_URL = "https://apexgpat.com/apex_exam/index.php/api_apex/"

    fun getInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}

