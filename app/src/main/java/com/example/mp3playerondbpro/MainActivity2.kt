package com.example.mp3playerondbpro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.mp3playerondbpro.databinding.ActivityMain2Binding

// 오디오를 통해서 사용자에게 원활한 영상을 제공한다.
class MainActivity2 : AppCompatActivity() {
    val binding by lazy {ActivityMain2Binding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root )


    }
}