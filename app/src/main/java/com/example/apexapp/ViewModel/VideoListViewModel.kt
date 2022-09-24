package com.example.apexapp.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apexapp.Model.VideoListModel
import com.example.apexapp.Repository.VideoListRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class VideoListViewModel(private  val repository : VideoListRepo) : ViewModel() {

    init {
        viewModelScope.launch { Dispatchers.IO
//             var su = "1"
//            var user_id= "1"
//
//            repository.getVideoData(su,user_id)
        }
    }

    val videoListData : LiveData<VideoListModel>
      get() = repository.videoData

    fun getVideoList(su: String, user_id : String)
    {
        viewModelScope.launch(Dispatchers.IO){
            repository.getVideoData(su, user_id)
        }
    }
}