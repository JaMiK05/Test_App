package com.example.Repository

import kotlin.collections.List as List1

class QuestionBase private constructor() {

    private val java_tests: ArrayList<Question> = ArrayList()
    private val kotlin_tests: ArrayList<Question> = ArrayList()

    companion object {
        lateinit var question: QuestionBase
        fun getIntance(): QuestionBase {
            if (!(Companion::question.isInitialized))
                question = QuestionBase()
            return question
        }
    }

    init {
        loadJavaTest()
        loadKotlinTest()
    }

    private fun loadJavaTest() {
        java_tests.add(Question("primitive toifalar nechchiga bo'linadi ? ",
            "2",
            "3",
            "7",
            "1",
            "3"))
        java_tests.add(
            Question(
                "String qanday toifa ? ",
                "Prmitive",
                "Reference",
                "String toifa emas",
                "to'g'ri javob mavjud emas",
                "Reference"
            )
        )
        java_tests.add(
            Question(
                "int toifasi xotiradan qancha joy egallaydi ? ",
                "3 bayt",
                "4 bayt",
                "5 bayt",
                "6 bayt",
                "4 bayt"
            )
        )
        java_tests.add(
            Question(
                "float toifasi xotiradan qancha joy egallaydi ? ",
                "3 bayt",
                "4 bayt",
                "5 bayt",
                "6 bayt",
                "4 bayt"
            )
        )
        java_tests.add(
            Question(
                "long toifasi xotiradan qancha joy egallaydi ? ",
                "8 bayt",
                "11 bayt",
                "10 bayt",
                "9 bayt",
                "8 bayt"
            )
        )
        java_tests.add(
            Question(
                "double toifasi xotiradan qancha joy egallaydi ? ",
                "8 bayt",
                "11 bayt",
                "10 bayt",
                "9 bayt",
                "8 bayt"
            )
        )
        java_tests.add(
            Question(
                "boolean toifasi xotiradan qancha joy egallaydi ? ",
                "3 bit",
                "1 bit",
                "5 bit",
                "8 bit",
                "1 bit"
            )
        )
        java_tests.add(
            Question(
                "interfacelar javaga qachon olib kirilgan ? ",
                "java 1.3",
                "java 1.5",
                "java 1.7",
                "java 1.9",
                "java 1.5"
            )
        )
        java_tests.add(
            Question(
                "funksional interface qachon olib kirilgan ? ",
                "java 1.8",
                "java 1.5",
                "java 1.7",
                "java 1.9",
                "java 1.8"
            )
        )
        java_tests.add(
            Question(
                "funksional interface qachon olib kirilgan ? ",
                "java 1.8",
                "java 1.5",
                "java 1.7",
                "java 1.9",
                "java 1.8"
            )
        )
    }

    private fun loadKotlinTest() {
        kotlin_tests.add(Question("Qachon Google Kotlin dasturlash tili endi Android ilovalari ishlab chiquvchilari uchun afzal qilingan til ekanligini eʼlon qildi",
            "2019 - yil 7 - may",
            "2020 - yil 7 - may",
            "2017 - yil 12 - dekabr",
            "2015 - yil 12 - may",
            "2019 - yil 7 - may"))
        kotlin_tests.add(Question("Google I/O  qaysi yilda Kotlin dasturlash tili Android-ning rivojlanishida ustuvor vazifaga aylanganligini ta'kidlab o'tdi.",
            "2021",
            "2019",
            "2015",
            "2018",
            "2019"))
        kotlin_tests.add(Question("(int:Int):Int\n funksiyaning return type nima",
            "Unit",
            "Int",
            "String",
            "return type qaytarmaydi",
            "Int"))
        kotlin_tests.add(Question("class Questions private constructor()\nbu clasdan obyekt olish mumkunmi",
            "olish mumkun",
            "mumkun emas",
            "single obyekt olish mumkun",
            "togri javob mavjud emas",
            "mumkun emas"))
        kotlin_tests.add(Question("class Questions(val int:Int)\nbu clasda maydon mavjudmi",
            "Int toifasida mavjud",
            "mavjud emas",
            "String toifasida mavjud",
            "togri javob mavjud emas",
            "Int toifasida mavjud"))
        kotlin_tests.add(Question("Qachon Google Kotlin dasturlash tili endi Android ilovalari ishlab chiquvchilari uchun afzal qilingan til ekanligini eʼlon qildi",
            "2019 - yil 7 - may",
            "2020 - yil 7 - may",
            "2017 - yil 12 - dekabr",
            "2015 - yil 12 - may",
            "2019 - yil 7 - may"))
        kotlin_tests.add(Question("Google I/O  qaysi yilda Kotlin dasturlash tili Android-ning rivojlanishida ustuvor vazifaga aylanganligini ta'kidlab o'tdi.",
            "2021",
            "2019",
            "2015",
            "2018",
            "2019"))
        kotlin_tests.add(Question("(int:Int):Int\n funksiyaning return type nima",
            "Unit",
            "Int",
            "String",
            "return type qaytarmaydi",
            "Int"))
        kotlin_tests.add(Question("class Questions private constructor()\nbu clasdan obyekt olish mumkunmi",
            "olish mumkun",
            "mumkun emas",
            "single obyekt olish mumkun",
            "togri javob mavjud emas",
            "mumkun emas"))
        kotlin_tests.add(Question("class Questions(val int:Int)\nbu clasda maydon mavjudmi",
            "Int toifasida mavjud",
            "mavjud emas",
            "String toifasida mavjud",
            "togri javob mavjud emas",
            "Int toifasida mavjud"))

    }

    fun getJavaTests(a: Int): List1<Question> {
        java_tests.shuffle()
        return java_tests.subList(0, a)
    }

    fun getKotlinTests(a: Int): List1<Question> {
        kotlin_tests.shuffle()
        return kotlin_tests.subList(0, a)
    }

}