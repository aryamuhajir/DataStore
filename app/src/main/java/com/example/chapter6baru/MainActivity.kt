package com.example.chapter6baru

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.asLiveData
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var userManager: UserManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userManager = UserManager(this)

        btnSave.setOnClickListener {
            val nama = edit1.text.toString()
            val umur = edit2.text.toString().toInt()

            GlobalScope.launch {
                userManager.saveData(nama, umur)
            }
        }

        userManager.userNama.asLiveData().observe(this, {
            txtHasil.text = it.toString()
        })
        userManager.userUmur.asLiveData().observe(this, {
            txtHasil2.text = it.toString()
        })

        btnClear.setOnClickListener {
            GlobalScope.launch {
                userManager.clearData()
            }
        }
    }
}