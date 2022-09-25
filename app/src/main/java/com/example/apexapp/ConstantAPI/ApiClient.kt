package com.example.rajpathbookreaderapp.ConstantAPI

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory



object ApiClient {
    private const val BASE_URL = "https://apexgpat.com/apex_exam/index.php/api_apex/"
     const val Video_Thumbnail = "https://www.apexgpat.com/apex_exam/upload_video_thumbnail/"
    const val  video = "https://www.apexgpat.com/apex_exam/upload_video/"

    fun getInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}

