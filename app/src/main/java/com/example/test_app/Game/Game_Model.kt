package com.example.test_app.Game

import com.example.Repository.Question
import com.example.Repository.QuestionBase

class Game_Model private constructor(int: Int) : Contract.Model {

    var savollar: List<Question>

    private var questionBase = QuestionBase.getIntance()
    private var position: Int

    init {
        savollar = if (int == 1)
            questionBase.getJavaTests(10)
        else
            questionBase.getKotlinTests(10)
        position = 0
    }

    companion object {
        lateinit var model: Game_Model
        fun getInctance(int: Int, til: Int): Game_Model {
            if (!(Companion::model.isInitialized) || int == 2) {
                model = Game_Model(til)
            }
            return model
        }
    }

    override fun lastQuestion(): Boolean {
        return position < 10
    }

    override fun getPosition(): Int {
        return position
    }

    override fun setPosition() {
        position--
    }

    override fun getMaxTest() = 10

    override fun nextTest() =
        savollar[position++]


}