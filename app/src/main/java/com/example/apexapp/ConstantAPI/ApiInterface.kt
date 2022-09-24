package com.example.rajpathbookreaderapp.ConstantAPI

import com.example.apexapp.Model.ForgotModel
import com.example.apexapp.Model.LoginModelX
import com.example.apexapp.Model.VideoListModel
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiInterface {

    @FormUrlEncoded
    @POST("login")
  suspend fun userLogin(@Field("username") username: String,@Field("password") password: String): Response<LoginModelX>

    @FormUrlEncoded
    @POST("forgot_password")
    suspend fun resetPass(@Field("user_email") user_email: String) :Response<ForgotModel>

    @FormUrlEncoded
    @POST("video_list")
    suspend fun getVideoList(@Field("su") su :String, @Field("user_id") user_id :String) : Response<VideoListModel>


}
