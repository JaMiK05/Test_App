package com.example.Repository

class Language {

    var til: Int = 0

    companion object {
        lateinit var language: Language
        fun getIntance(): Language {
            if (!(Companion::language.isInitialized)) {
                language = Language()
            }
            return language
        }
    }

}