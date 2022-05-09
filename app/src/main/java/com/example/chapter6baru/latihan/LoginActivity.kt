package com.example.chapter6baru.latihan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.asLiveData
import com.example.chapter6baru.R
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class LoginActivity : AppCompatActivity() {
    lateinit var loginManager: LoginManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        loginManager = LoginManager(this)

        btnRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
        btnLogin.setOnClickListener {
            var userInput = editUser.text.toString()
            var passInput = editPassword.text.toString()
            loginManager.userNAME.asLiveData().observe(this) {
                if (userInput == it){
                    loginManager.userPASS.asLiveData().observe(this) {
                        if (passInput == it){
                            GlobalScope.launch {
                                loginManager.setStatus("yes")
                            }
                            startActivity(Intent(this, HomeActivity::class.java))


                        }else{
                            Toast.makeText(this, "USERNAME ATAU PASSWORD SALAH", Toast.LENGTH_LONG).show()

                        }
                    }
                }else{
                    Toast.makeText(this, "USERNAME ATAU PASSWORD SALAH", Toast.LENGTH_LONG).show()

                }
            }




        }
    }
}