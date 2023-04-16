package com.example.mp3playerondbpro.Genre

import android.os.Bundle
import android.view.MenuItem
import android.widget.AdapterView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.mp3playerondbpro.R
import com.example.mp3playerondbpro.databinding.ActivityMain3Binding

class MainActivity3 : AppCompatActivity() {
    private lateinit var binding: ActivityMain3Binding
    lateinit var genreList: MutableList<Genre>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // 그리드 뷰 어댑터 설정
        genreList = mutableListOf(
            Genre(R.drawable.mp3_img_01, "Pop"),
            Genre(R.drawable.mp3_img_02, "Rock"),
            Genre(R.drawable.mp3_img_03, "Hip Hop"),
            Genre(R.drawable.mp3_img_04, "R&B"),
            Genre(R.drawable.mp3_img_05, "Jazz"),
            Genre(R.drawable.mp3_img_06, "K-pop"),
            Genre(R.drawable.mp3_img_07, "Electronic"),
            Genre(R.drawable.mp3_img_08, "Reggae")
        )
        binding.gridView.adapter = GenreAdapter(genreList)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // 그리드 뷰 아이템 클릭 이벤트 처리
        binding.gridView.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id ->
                Toast.makeText(this, "Clicked item $position", Toast.LENGTH_SHORT).show()
            }

        // 툴바를 액티비티에 설정
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        // 패키지명을 숨기기 위해 타이틀을 비움
        supportActionBar?.title = ""

    }
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