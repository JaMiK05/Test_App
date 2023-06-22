package com.example.Repository

class List_to_Result private constructor() {

    private var testlar: List<Question>
    private var javoblar: List<String>


    companion object {
        private lateinit var list: List_to_Result
        public fun getIntance(): List_to_Result {
            if (!(Companion::list.isInitialized)) {
                list = List_to_Result()
            }
            return list
        }
    }

    init {
        testlar = arrayListOf()
        javoblar = arrayListOf()
    }

    public fun setLists(test: List<Question>, javob: List<String>) {
        testlar = test
        javoblar = javob
    }

    public fun getTest(): List<Question> {
        return testlar
    }

    public fun getjavob(): List<String> {
        return javoblar
    }


}