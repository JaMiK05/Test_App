package com.example.test_app.Game

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.Diaolgs.Dialog_main
import com.example.Repository.Language
import com.example.Repository.Question
import com.example.test_app.R
import com.example.test_app.Results.Result_Activity
import com.example.test_app.databinding.ActivityGameBinding

class Game_Activity : AppCompatActivity(), Contract.View {

    private lateinit var javoblar: ArrayList<LinearLayout>
    private var str: String = ""

    private var _bindig: ActivityGameBinding? = null
    private val binding get() = _bindig!!
    private lateinit var language: Language

    private lateinit var gamePresenter: Game_Presenter

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _bindig = ActivityGameBinding.inflate(layoutInflater)
        setContentView(binding.root)
        language = Language.getIntance()

        val intent = this.intent
        val str: String = if (language.til == 1) "Java" else "Kotlin"
        findViewById<TextView>(R.id.tool_text).text = str
        gamePresenter = Game_Presenter(this, intent.getIntExtra("ne", 2))
        loadData()
    }

    private fun loadData() {
        binding.apply {
            javoblar = ArrayList()
            javoblar.add(j1)
            javoblar.add(j2)
            javoblar.add(j3)
            javoblar.add(j4)
            backtest.setOnClickListener { gamePresenter.backActivity() }
            skip.setOnClickListener { gamePresenter.skipButton() }
            next.setOnClickListener {
                gamePresenter.nextButton(str)
                str = ""
            }
            next.isEnabled = false
            restart.setOnClickListener {
                val dialog = Dialog_main(this@Game_Activity)
                dialog.setnew {
                    gamePresenter.newGame()
                }
                dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                dialog.show()
            }
        }
        gamePresenter.nextQuestion()
        loadListener()
    }

    private fun loadListener() {
        for (i in 0 until javoblar.size) {
            javoblar.get(i).setOnClickListener {
                clear()
                javoblar[i].setBackgroundResource(R.drawable.card_green)
                binding.apply {
                    next.isEnabled = true
                }
                val txn: TextView = javoblar[i].getChildAt(0) as TextView
                str = txn.text.toString()
            }
        }

    }

    private fun clear() {
        for (i in 0 until javoblar.size) {
            javoblar.get(i).setBackgroundResource(R.drawable.card)
        }
    }

    override fun nextACtivity() {
        startActivity(Intent(this, Result_Activity::class.java))
        finish()
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        gamePresenter.backActivity()
    }

    @SuppressLint("SetTextI18n")
    override fun saveData(question: Question, i: Int, n: Int) {

        binding.apply {
            nechinchiSavol.text = "$i/$n"
            savol.text = question.question
            javob1.text = question.variant1
            javob2.text = question.variant2
            javob3.text = question.variant3
            javob4.text = question.variant4
            next.isEnabled = false
        }
        clear()
    }


}