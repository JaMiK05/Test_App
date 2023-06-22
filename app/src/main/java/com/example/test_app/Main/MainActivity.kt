package com.example.test_app.Main

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.Repository.Language
import com.example.test_app.databinding.ActivityMainBinding
import com.example.test_app.info.Info_Activity
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var mainPesenter: MainPresenter

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    private lateinit var language: Language

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        language = Language.getIntance()
        loadData()
    }

    fun loadData() {
        mainPesenter = MainPresenter(this)
        binding.apply {
            javaPlay.setOnClickListener {
                mainPesenter.nextTestActivity(2)
                language.til = 1
            }
            kotlinPlay.setOnClickListener {
                mainPesenter.nextTestActivity(2)
                language.til = 2
            }

            exitMaint.setOnClickListener {
                mainPesenter.exit()
            }

            infoApk.setOnClickListener {
                startActivity(Intent(this@MainActivity, Info_Activity::class.java))
            }
            Randm.setOnClickListener {
                when (Random().nextInt(2)) {
                    0 -> {
                        mainPesenter.nextTestActivity(2)
                        language.til = 1
                    }
                    1 -> {
                        mainPesenter.nextTestActivity(2)
                        language.til = 2
                    }
                }
            }

            if (language.til == 0) maint.isEnabled = false
            maint.setOnClickListener {
                mainPesenter.nextTestActivity(1)
            }
        }
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        mainPesenter.exit()
    }

}
