package com.example.test_app.read

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.Repository.Language
import com.example.Repository.List_to_Result
import com.example.test_app.R
import com.example.test_app.databinding.ActivityReadBinding

class ReadActivity : AppCompatActivity() {

    private var _binding: ActivityReadBinding? = null
    private val binding get() = _binding!!

    @SuppressLint("SetTextI18n", "ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityReadBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val test = List_to_Result.getIntance().getTest()
        val javob = List_to_Result.getIntance().getjavob()
        val language = Language.getIntance()

        val a = this.intent.getIntExtra("it", 0)
        binding.apply {

            val str: String = if (language.til == 1) "Java" else "Kotlin"
            toolTitle.text = str
            nechinchiSavol.text = "${a + 1}"
            savol.text = test[a].question
            javob1.text = test[a].variant1
            if (javob[a] == test[a].variant1) {
                j1.setBackgroundResource(R.drawable.card_red)
            }
            if (test[a].variant1 == test[a].answer) {
                j1.setBackgroundResource(R.drawable.card_green)
            }
            javob2.text = test[a].variant2
            if (javob[a] == test[a].variant2) {
                j2.setBackgroundResource(R.drawable.card_red)
            }
            if (test[a].variant2 == test[a].answer) {
                j2.setBackgroundResource(R.drawable.card_green)
            }
            javob3.text = test[a].variant3
            if (javob[a] == test[a].variant3) {
                j3.setBackgroundResource(R.drawable.card_red)
            }
            if (test[a].variant3 == test[a].answer) {
                j3.setBackgroundResource(R.drawable.card_green)
            }
            javob4.text = test[a].variant4
            if (javob[a] == test[a].variant4) {
                j4.setBackgroundResource(R.drawable.card_red)
            }
            if (test[a].variant4 == test[a].answer) {
                j4.setBackgroundResource(R.drawable.card_green)
            }
            back.setOnClickListener {
                onBackPressed()
            }
        }
    }

    override fun onBackPressed() {
        finish()
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

}