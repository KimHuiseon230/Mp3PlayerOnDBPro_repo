package com.example.mp3playerondbpro.Genre

import android.os.Bundle
import android.view.MenuItem
import android.widget.AdapterView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
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
            Genre(R.drawable.ic_launcher_background, "Pop"),
            Genre(R.drawable.ic_launcher_background, "Rock"),
            Genre(R.drawable.ic_launcher_background, "Hip Hop"),
            Genre(R.drawable.ic_launcher_background, "R&B"),
            Genre(R.drawable.ic_launcher_background, "Jazz"),
            Genre(R.drawable.ic_launcher_background, "K-pop"),
            Genre(R.drawable.ic_launcher_background, "Electronic"),
            Genre(R.drawable.ic_launcher_background, "Reggae")
        )
        binding.gridView.adapter = GenreAdapter(genreList)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // 그리드 뷰 아이템 클릭 이벤트 처리
        binding.gridView.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id ->
                Toast.makeText(this, "Clicked item $position", Toast.LENGTH_SHORT).show()
            }
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