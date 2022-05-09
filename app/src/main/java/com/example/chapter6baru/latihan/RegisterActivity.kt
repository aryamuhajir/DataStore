package com.example.chapter6baru.latihan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.chapter6baru.R
import com.example.chapter6baru.UserManager
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class RegisterActivity : AppCompatActivity() {
    lateinit var loginManager: LoginManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        loginManager = LoginManager(this)

        btnRegister2.setOnClickListener {
            val username = editUserR.text.toString()
            val password = editPasswordR.text.toString()

            GlobalScope.launch {
                loginManager.register(username, password)

            }
            finish()
        }
    }
}