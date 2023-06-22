package com.example.test_app.Game

import com.example.Repository.Question

interface Contract {

    interface View {
        fun nextACtivity()
        fun saveData(question: Question, i: Int, n: Int)
    }

    interface Prsenter {
        fun newGame()
        fun skipButton()
        fun nextButton(str: String)
        fun nextQuestion()
        fun backActivity()
    }


    interface Model {

        fun lastQuestion(): Boolean


        fun setPosition()

        fun getPosition(): Int

        fun getMaxTest(): Int

        fun nextTest(): Question

    }

}