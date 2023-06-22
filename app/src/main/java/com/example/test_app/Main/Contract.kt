package com.example.test_app.Main

interface Contract {

    interface View {
    }

    interface Presenter {
        val mainactivity: MainActivity
        fun nextInfoActivity()
        fun nextTestActivity(int_n: Int)
        fun exit()
    }

    interface Model {

    }


}