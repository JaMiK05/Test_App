package com.example.test_app.Game

import android.content.Intent
import com.example.Repository.Language
import com.example.Repository.List_to_Result
import com.example.test_app.Main.MainActivity

class Game_Presenter(val gameActivity: Game_Activity, int: Int) : Contract.Prsenter {

    private val tt = Language.getIntance().til
    private var model: Game_Model = Game_Model.getInctance(int, tt)
    var javoblar: ArrayList<String> = arrayListOf()


    override fun newGame() {
        model = Game_Model.getInctance(2, tt)
        nextQuestion()
    }

    override fun skipButton() {
        javoblar.add("")
        nextQuestion()
    }

    override fun nextButton(str: String) {
        javoblar.add(str)
        nextQuestion()
    }

    override fun nextQuestion() {
        if (model.lastQuestion())
            gameActivity.saveData(model.nextTest(), model.getPosition(), 10)
        else {
            List_to_Result.getIntance().setLists(model.savollar, javoblar)
            gameActivity.nextACtivity()
        }
    }

    override fun backActivity() {
        model.setPosition()
        gameActivity.startActivity(Intent(gameActivity, MainActivity::class.java))
        gameActivity.finish()
    }


}
