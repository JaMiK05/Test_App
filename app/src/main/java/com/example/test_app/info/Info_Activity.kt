package com.example.test_app.info

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.test_app.databinding.ActivityInfoBinding


class Info_Activity : AppCompatActivity() {

    private var _binding: ActivityInfoBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
            backinfo.setOnClickListener {
                finish()
            }
            telegram.setOnClickListener {
                val uri = Uri.parse("https://t.me/jamik_gamer")
                val intent = Intent(Intent.ACTION_VIEW, uri)
                startActivity(intent)
            }
            instagram.setOnClickListener {
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://instagram.com/_mr.jamik_?igshid=ZDdkNTZiNTM=")))
            }
            tik.setOnClickListener {
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://vt.tiktok.com/ZS8bS8G8D/")))
            }
        }
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
    
}





