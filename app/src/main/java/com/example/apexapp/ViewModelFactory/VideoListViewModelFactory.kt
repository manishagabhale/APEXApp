package com.example.apexapp.ViewModelFactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.apexapp.Repository.VideoListRepo
import com.example.apexapp.ViewModel.VideoListViewModel

class VideoListViewModelFactory(private val repository : VideoListRepo) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
       return VideoListViewModel(repository) as T
    }
}