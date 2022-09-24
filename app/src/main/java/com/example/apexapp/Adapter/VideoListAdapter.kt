package com.example.apexapp.Adapter

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.apexapp.Model.Result
import com.example.apexapp.Model.VideoListModel
import com.example.apexapp.databinding.ListItemVideolListBinding
import com.example.rajpathbookreaderapp.ConstantAPI.ApiClient
import com.squareup.picasso.Picasso


class VideoListAdapter() : RecyclerView.Adapter<VideoListAdapter.MainViewHolder>() {

    class MainViewHolder(val binding: ListItemVideolListBinding) :
        RecyclerView.ViewHolder(binding.root) {
    }

    var videolist = mutableListOf<Result>()
    fun setVideoList(videos: List<Result>) {
        this.videolist = videos.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view = LayoutInflater.from(parent.context)
        val binding = ListItemVideolListBinding.inflate(view, parent, false)
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val videos = videolist[position]


        holder.binding.txtVideoName.text = videos.video_name

        Picasso.get()
            .load(videos.video_thumbnail)
            .into(holder.binding.imgVideo)


    }

    override fun getItemCount(): Int {
        return videolist.size
    }

}
