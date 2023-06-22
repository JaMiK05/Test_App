package com.example.test_app.Results

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.Repository.Language
import com.example.Repository.List_to_Result
import com.example.test_app.Main.MainActivity
import com.example.test_app.databinding.ActivityResultBinding
import com.example.test_app.read.ReadActivity

class Result_Activity : AppCompatActivity() {

    private var _binding: ActivityResultBinding? = null
    private val binding get() = _binding!!

    private val test = List_to_Result.getIntance().getTest()
    private val javob = List_to_Result.getIntance().getjavob()

    private var t = 0
    private var f = 0
    private var s = 0

    private lateinit var language: Language

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        language = Language.getIntance()
        settings()
        val str: String = if (language.til == 1) "Java" else "Kotlin"
        binding.apply {
            resultTil.text = str
            rTrue.text = "$t"
            rFalse.text = "$f"
            rSkip.text = "$s"
            val adap = Adapters(test, javob)
            backMain.setOnClickListener {
                onBackPressed()
            }
            recyclerView.adapter = adap
            adap.setclick {
                startActivity(Intent(this@Result_Activity, ReadActivity::class.java).putExtra("it",
                    it))
            }
            recyclerView.layoutManager =
                LinearLayoutManager(this@Result_Activity, LinearLayoutManager.VERTICAL, false)
        }
    }

    private fun settings() {
        for (i in test.indices) {
            if (javob[i] == "") s++
            else if (test[i].answer == javob[i]) t++
            else f++
        }
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

    override fun onBackPressed() {
        language.til = 0
        startActivity(Intent(this@Result_Activity, MainActivity::class.java))
        finish()
    }

}