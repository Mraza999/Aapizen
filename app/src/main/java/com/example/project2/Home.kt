package com.example.project2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_home.*

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        val i = intent
        val get_message = i.getStringExtra("message")

        displayAtHome.text = "Warm Welcome to you " + get_message



        logout_Btn.setOnClickListener()
        {
            val alert = AlertDialog.Builder(this)

            alert.setTitle("Logout Confirmation")
            alert.setMessage("Are you sure you want to log out?")
            alert.setPositiveButton("Yes"){_,which ->
                finish()}
            alert.setNegativeButton("No"){_,which ->}

            alert.create().show()

        }
    }
}