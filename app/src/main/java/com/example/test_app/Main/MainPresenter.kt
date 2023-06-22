package com.example.test_app.Main

import android.content.Intent
import com.example.test_app.Game.Game_Activity

class MainPresenter(override val mainactivity: MainActivity) : Contract.Presenter {

    private val mainModel: MainModel = MainModel()



    override fun nextInfoActivity() {
        mainactivity.startActivity(
            Intent(mainactivity, Game_Activity::class.java)
        )

    }

    override fun nextTestActivity(int_n: Int) {
        mainactivity.startActivity(
            Intent(mainactivity, Game_Activity::class.java)
                .putExtra("ne", int_n)
        )
        mainactivity.finish()
    }

    override fun exit() {
        mainactivity.finishAffinity()
    }
}