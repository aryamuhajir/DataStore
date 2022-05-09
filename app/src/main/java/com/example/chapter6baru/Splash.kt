package com.example.chapter6baru

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowManager
import androidx.lifecycle.asLiveData
import com.example.chapter6baru.latihan.HomeActivity
import com.example.chapter6baru.latihan.LoginActivity
import com.example.chapter6baru.latihan.LoginManager

class Splash : AppCompatActivity() {
    lateinit var loginManager: LoginManager
    lateinit var status : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        loginManager = LoginManager(this)


        this.window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        // we used the postDelayed(Runnable, time) method
        // to send a message with a delayed time.
        Handler(Looper.getMainLooper()).postDelayed({
            loginManager.userSTATUS.asLiveData().observe(this) {
                if (it.equals("yes")){
                    startActivity(Intent(this, HomeActivity::class.java))
                }else{
                    startActivity(Intent(this, LoginActivity::class.java))

                }
            }

            finish()
        }, 3000) // 3000 is the delayed time in milliseconds.
    }
}