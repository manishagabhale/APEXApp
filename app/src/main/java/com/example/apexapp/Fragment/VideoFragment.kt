package com.example.apexapp.Fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apexapp.Adapter.VideoListAdapter
import com.example.apexapp.ConstantAPI.MainApplication
import com.example.apexapp.ConstantAPI.PrefConfig
import com.example.apexapp.Repository.VideoListRepo
import com.example.apexapp.ViewModel.VideoListViewModel
import com.example.apexapp.ViewModelFactory.VideoListViewModelFactory
import com.example.apexapp.databinding.FragmentVideoBinding
import com.example.rajpathbookreaderapp.ConstantAPI.ApiClient
import com.example.rajpathbookreaderapp.ConstantAPI.ApiInterface

class VideoFragment : Fragment()  {
    private var _binding : FragmentVideoBinding? = null
    private val binding get() = _binding!!

    lateinit var videoListViewModel: VideoListViewModel
    var videoListAdapter = VideoListAdapter()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentVideoBinding.inflate(inflater,container,false)
        val view = binding.root

        val api = ApiClient.getInstance().create(ApiInterface::class.java)
        val repository = VideoListRepo(api)

        videoListViewModel = ViewModelProvider(this, VideoListViewModelFactory(repository)).get(VideoListViewModel::class.java)

        binding!!.videoRv.layoutManager = LinearLayoutManager(activity)
        binding.videoRv?.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)

        binding!!.videoRv.adapter = videoListAdapter

        var userId = PrefConfig(MainApplication.applicationContext()).readUserId()
        println("userId-->$userId")

        videoListViewModel.getVideoList("1", userId.toString())
        videoListViewModel.videoListData.observe(viewLifecycleOwner, Observer {
            Log.d("VideoList", it.result.toString())

            videoListAdapter.setVideoList(it.result)

        })
        videoListViewModel.videoListData
        return  view
    }



}