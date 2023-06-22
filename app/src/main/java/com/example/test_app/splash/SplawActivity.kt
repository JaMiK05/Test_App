package com.example.test_app.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.test_app.Main.MainActivity
import com.example.test_app.databinding.ActivitySplashBinding

class SplawActivity : AppCompatActivity() {

    private var _binding: ActivitySplashBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this@SplawActivity, MainActivity::class.java))
            finish()
        }, 1500)
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

}