package com.example.apexapp.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.apexapp.Activity.VideoDetailActivity
import com.example.apexapp.Model.Result
import com.example.apexapp.databinding.ListItemVideoListBinding
import com.example.rajpathbookreaderapp.ConstantAPI.ApiClient
import com.squareup.picasso.Picasso


class VideoListAdapter() : RecyclerView.Adapter<VideoListAdapter.MainViewHolder>() {

    class MainViewHolder(val binding: ListItemVideoListBinding) :
        RecyclerView.ViewHolder(binding.root) {
    }

    var videolist = mutableListOf<Result>()
    fun setVideoList(videos: List<Result>) {
        this.videolist = videos.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view = LayoutInflater.from(parent.context)
        val binding = ListItemVideoListBinding.inflate(view, parent, false)
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val videos = videolist[position]


        holder.binding.txtVideoName.text = videos.video_name

        Picasso.get()
            .load(ApiClient.Video_Thumbnail + videos.video_thumbnail)
            .into(holder.binding.imgVideo)

        holder.itemView.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                val intent = Intent(v!!.context, VideoDetailActivity::class.java)
                v.context.startActivity(intent)
            }
        })

    }

    override fun getItemCount(): Int {
        return videolist.size
    }

}
