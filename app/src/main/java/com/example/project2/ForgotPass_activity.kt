package com.example.project2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_forgot_pass.*

class ForgotPass_activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_pass)



        ForgetP_btn.setOnClickListener()
        {
            val dataForgetE:String = ForgetP_mail.text.toString()

            if (dataForgetE.isNotEmpty()) {
                if (ValidateForgetEmail(dataForgetE))
                {
                    startActivity(Intent(this,Home::class.java))
//                    val i = Intent(this,Home::class.java)
//                    startActivity(i)

                } else {
                    ForgetP_mail.error = "Email is invalid!"
                }
            }
            else
            {
                ForgetP_mail.error = "Email field can't be empty!"
            }
        }
    }

    private fun ValidateForgetEmail(dataForgetE: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(dataForgetE).matches()
    }
}