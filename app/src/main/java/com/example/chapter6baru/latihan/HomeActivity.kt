package com.example.chapter6baru.latihan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.asLiveData
import com.example.chapter6baru.R
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class HomeActivity : AppCompatActivity() {
    lateinit var loginManager: LoginManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        loginManager = LoginManager(this)

        loginManager.userNAME.asLiveData().observe(this, {
            txtUser.text = it
        })

        btnLogout.setOnClickListener {
            GlobalScope.launch {
                loginManager.setStatus("no")
            }
            startActivity(Intent(this, LoginActivity::class.java))
            finish()

        }

    }
}