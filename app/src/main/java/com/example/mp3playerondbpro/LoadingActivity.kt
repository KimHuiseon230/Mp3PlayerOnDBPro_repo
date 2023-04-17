package com.example.mp3playerondbpro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.mp3playerondbpro.databinding.ActivityLodingBinding

class LoadingActivity : AppCompatActivity() {
    val binding by lazy { ActivityLodingBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        startLoading()
    }
    fun startLoading() {
        Handler().postDelayed({
            finish()
        }, 4000)
        Toast.makeText(applicationContext, "하단에 있는 오디오 사용시 통신료 이용료가 발생될수 있습니다.",Toast.LENGTH_SHORT).show()
        Glide.with(this).load(R.raw.splash).override(250,250).into(binding.ivSplash)
    }
}