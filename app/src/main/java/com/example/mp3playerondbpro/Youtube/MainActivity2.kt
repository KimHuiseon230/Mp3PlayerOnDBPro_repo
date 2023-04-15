package com.example.mp3playerondbpro.Youtube

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
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
        youtubeList.add(youtubeData(R.drawable.music_24, "ASMRTest1", "EsD-QcfHkDQ"))
        youtubeList.add(youtubeData(R.drawable.music_24, "ASMRTest2", "ir7uFl7DGyA"))
        youtubeList.add(youtubeData(R.drawable.music_24, "ASMRTest3", "sleVP0qisl8"))

        binding.recyclerView.adapter = CustomYoutubeAdapter(youtubeList)
        val layoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.addItemDecoration(DividerItemDecoration(this, 1))

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

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