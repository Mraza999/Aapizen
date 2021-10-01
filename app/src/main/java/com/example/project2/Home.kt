package com.example.project2

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_home.*
import java.net.URI

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        val i = intent
        val getmessage = i.getStringExtra("message")

        displayAtHome.text = "Warm Welcome to you " + getmessage



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

    fun Navigate(view: android.view.View)
    {
        val webUrl :Uri = Uri.parse(UrlEditTxt.text.toString())
        val i = Intent(Intent.ACTION_VIEW,webUrl)
        startActivity(i)
    }

    fun Dial(view: android.view.View)
    {
        val webUrl :Uri = Uri.parse("tel: 03454476421" )
        val i = Intent(Intent.ACTION_DIAL,webUrl)
        startActivity(i)
    }


//    fun Map(view: android.view.View)
//    {
//        val webUrl :Uri = Uri.parse("geo:0,0?q=" + MapLink.text.toString())
//        val i = Intent(Intent.ACTION_VIEW,webUrl)
//        startActivity(i)
//    }


    fun Camera(view: android.view.View)
    {
        val webUrl :Uri = Uri.parse("android.media.action.IMAGE_CAPTURE" + CameraLink.text.toString())
        val i = Intent(Intent.ACTION_CALL_BUTTON,webUrl)
        startActivity(i)
    }
}