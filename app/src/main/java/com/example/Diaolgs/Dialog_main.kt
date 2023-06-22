package com.example.Diaolgs

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import com.example.test_app.databinding.DialogMainBinding


class Dialog_main(context: Context) : AlertDialog(context) {

    private lateinit var neww: () -> Unit
    private var _binding: DialogMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = DialogMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadData()
    }

    fun setnew(cal: () -> Unit) {
        neww = cal
    }

    private fun loadData() {
        binding.apply {
            continueMainDialog.setOnClickListener {
                dismiss()
                neww.invoke()
            }
            newMainDialog.setOnClickListener {
             dismiss()
            }
        }
    }
}