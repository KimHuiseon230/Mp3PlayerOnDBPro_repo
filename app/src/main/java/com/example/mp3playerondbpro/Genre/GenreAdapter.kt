package com.example.mp3playerondbpro.Genre

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.mp3playerondbpro.R

class GenreAdapter(val genreList: MutableList<Genre>) : BaseAdapter() {

    override fun getCount(): Int {
        return genreList.size
    }

    override fun getItem(position: Int): Any {
        return genreList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = convertView ?: LayoutInflater.from(parent?.context).inflate(R.layout.grid_item_genre, parent, false)

        // 그리드 뷰 아이템 이미지와 제목 설정
        val genre = genreList[position]
        val imageView = view.findViewById<ImageView>(R.id.grid_item_image)
        genre.imageId?.let { imageView.setImageResource(it) }

        val textView = view.findViewById<TextView>(R.id.grid_item_title)
        textView.text = genre.name

        textView.text = genre.name

        return view
    }
}

