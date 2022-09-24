package com.example.apexapp.Repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.apexapp.Model.VideoListModel
import com.example.rajpathbookreaderapp.ConstantAPI.ApiInterface

class VideoListRepo(private  val videoApi : ApiInterface) {

    private val videoLiveData = MutableLiveData<VideoListModel>()

     val videoData : LiveData<VideoListModel>
            get() = videoLiveData

    suspend fun getVideoData(su:String , user_id: String)
    {
        val result =  videoApi.getVideoList(su,user_id)

        if (result.body() != null)
        {
            if (result.isSuccessful)
                videoLiveData.postValue(result.body())
        }
    }
}