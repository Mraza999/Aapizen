package com.example.project2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.v4.os.HandlerCompat.postDelayed

class Splash_activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)


        Handler().postDelayed({splashFunc()},3000)
    }



    private fun splashFunc() {
        val i = Intent(this,LogIn_activity::class.java)
        startActivity(i)
        finish()
    }
}


