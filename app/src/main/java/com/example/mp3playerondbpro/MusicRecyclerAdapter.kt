package com.example.mp3playerondbpro

import android.content.Context
import android.content.Intent
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.mp3playerondbpro.databinding.ItemRecyclerBinding
import java.text.SimpleDateFormat

class MusicRecyclerAdapter(val context: Context, val musicList: MutableList<MusicData>) :
    RecyclerView.Adapter<MusicRecyclerAdapter.CustomViewHolder>() {
    val ALBUM_IMAGE_SIZE = 90

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val binding =
            ItemRecyclerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CustomViewHolder(binding)
    }

    override fun getItemCount() = musicList.size

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val binding = holder.binding
        // 이미지, artist, title, duration binding 가져오기
        val bitmap = musicList.get(position).getAlbumBitmap(context, ALBUM_IMAGE_SIZE)
        if (bitmap != null) {
            binding.ivAlbumArt.setImageBitmap(bitmap)
        } else {
            binding.ivAlbumArt.setImageResource(R.drawable.music_24)
        }
        when(musicList.get(position).likes ){
            0->{ binding.ivItemLike.setImageResource(R.drawable.favorite_border_24)}
            1->{ binding.ivItemLike.setImageResource(R.drawable.favorite_24)}
        }
        binding.tvArtist.text = musicList.get(position).artist
        binding.tvTitle.text = musicList.get(position).title
        binding.tvDuration.text =
            SimpleDateFormat("mm:ss").format(musicList.get(position).duration)
        // 아이템 항목 클릭시 PlayActivity로 MusicData 전달
        binding.root.setOnClickListener {
            val intent = Intent(binding.root.context, PlayActivity::class.java)
            val parcelableList :ArrayList<Parcelable>? =musicList as ArrayList<Parcelable>

            intent.putExtra("parcelableList", parcelableList) // 하나만 넘어감 다 넘길려면 mutableList로 해야됨 (과제부분)
            intent.putExtra("position",position)
            binding.root.context.startActivity(intent)
//            intent.putExtra("musicData", musicList.get(position))
        }
        binding.ivItemLike.setOnClickListener {
        when(musicList.get(position).likes){
            1-> { musicList.get(position).likes= 0
                binding.ivItemLike.setImageResource(R.drawable.favorite_24) }

            0-> { musicList.get(position).likes= 1
                binding.ivItemLike.setImageResource(R.drawable.favorite_border_24) }
            }
            val db = DBOpenHelper(context, MainActivity.DB_NAME, MainActivity.VERSION) // 새로 만들어진게 아니라 기존
            var errorFlag = db.updateLike(musicList.get(position))

            if(errorFlag){
                Toast.makeText(context,"updateLikes 실패",Toast.LENGTH_SHORT).show()
            }else{
                this.notifyDataSetChanged()// 값을 싹 바꿈.
            }
        }
    }

    inner class CustomViewHolder(val binding: ItemRecyclerBinding) :
        RecyclerView.ViewHolder(binding.root)
}