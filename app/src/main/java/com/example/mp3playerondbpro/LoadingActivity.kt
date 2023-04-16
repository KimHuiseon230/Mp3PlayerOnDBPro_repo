package com.example.mp3playerondbpro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
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
        Glide.with(this).load(R.raw.splash).override(250,250).into(binding.ivSplash)
    }
}