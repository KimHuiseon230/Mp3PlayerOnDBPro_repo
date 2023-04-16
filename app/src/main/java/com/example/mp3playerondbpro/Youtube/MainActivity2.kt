package com.example.mp3playerondbpro.Youtube

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mp3playerondbpro.R
import com.example.mp3playerondbpro.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    val binding by lazy { ActivityMain2Binding.inflate(layoutInflater) }
    lateinit var youtubeList: MutableList<youtubeData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        youtubeList = mutableListOf<youtubeData>()
        youtubeList.add(youtubeData(R.drawable.music_24, getString(R.string.youtube_string1), "dvsgp4Op2z0"))
        youtubeList.add(youtubeData(R.drawable.music_24, getString(R.string.youtube_string2), "sgL_waepEL4"))
        youtubeList.add(youtubeData(R.drawable.music_24, getString(R.string.youtube_string3),"Jwpnifuh0KI"))
        youtubeList.add(youtubeData(R.drawable.music_24, getString(R.string.youtube_string4), "nSkPYON34Ok"))
        youtubeList.add(youtubeData(R.drawable.music_24, getString(R.string.youtube_string5), "Tz6uGjDgcDQ"))
        youtubeList.add(youtubeData(R.drawable.music_24, getString(R.string.youtube_string6), "llWNm5kyh34"))
        youtubeList.add(youtubeData(R.drawable.music_24, getString(R.string.youtube_string7), "w6IQXHYw_hw"))
        youtubeList.add(youtubeData(R.drawable.music_24, getString(R.string.youtube_string8), "KdZv80_eXW8"))
        youtubeList.add(youtubeData(R.drawable.music_24, getString(R.string.youtube_string9), "7yRiztcFPI0"))
        youtubeList.add(youtubeData(R.drawable.music_24, getString(R.string.youtube_string10), "Bs47iAKwMqw"))


        binding.recyclerView.adapter = CustomYoutubeAdapter(youtubeList)
        val layoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.addItemDecoration(DividerItemDecoration(this, 1))

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        // 툴바를 액티비티에 설정
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        // 패키지명을 숨기기 위해 타이틀을 비움
        supportActionBar?.title = ""

        //+++ toolbar
    }// 툴바의 뒤로가기 버튼 클릭 시 액티비티 종료
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed() // 뒤로가기 버튼과 동일한 기능
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}