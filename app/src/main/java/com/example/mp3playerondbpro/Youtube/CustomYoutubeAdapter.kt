package com.example.mp3playerondbpro.Youtube

import android.content.Intent
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mp3playerondbpro.databinding.ItemYoutubeBinding
import com.bumptech.glide.Glide

class CustomYoutubeAdapter(val youtubeList: MutableList<youtubeData>) :
    RecyclerView.Adapter<CustomYoutubeAdapter.CustomViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val binding = ItemYoutubeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CustomViewHolder(binding)
    }

    override fun getItemCount(): Int = youtubeList.size

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val binding = holder.binding

        binding.tvTitle.text = youtubeList[position].title
        Glide.with(binding.root.context)
            .load("https://img.youtube.com/vi/${youtubeList[position].videoId}/hqdefault.jpg")
            .into(binding.ivPicture)
        binding.root.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=${youtubeList[position].videoId}"))
            binding.root.context.startActivity(intent)
        }
        Log.d("CustomYoutubeAdapter", "videoId: ${youtubeList[position].videoId}")

    }

    class CustomViewHolder(val binding: ItemYoutubeBinding) : RecyclerView.ViewHolder(binding.root)
}
