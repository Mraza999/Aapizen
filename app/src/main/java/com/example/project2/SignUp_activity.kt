package com.example.project2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUp_activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)


        val sign_btn = findViewById<Button>(R.id.SignUp_btn)






        val login_lnk = findViewById<Button>(R.id.login_link)

        login_lnk.setOnClickListener()
        {
            val i = Intent(this, LogIn_activity::class.java)
            startActivity(i)
        }




        // VALIDATION SIGN UP FORM
        sign_btn.setOnClickListener()
        {
            val dataFname: String = FirstN.text.toString()
            val dataLname: String = LastN.text.toString()
            val dataEmail: String = Email.text.toString()
            val dataPass:  String = Password.text.toString()
            val dataRadioM: String = radioBtnMale.text.toString()
            val dataRadioF: String = radioBtnFemale.text.toString()




            // FIRSTNAME VALIDATION
            if (dataFname.isNotEmpty()) {
                if (dataFname.length <= 8) {
                } else {
                    FirstN.error = "First Name length must be less than or equal 8"
                    return@setOnClickListener
                }

            } else {
                FirstN.error = "First Name can't be empty"
                return@setOnClickListener
            }


            // LASTNAME VALIDATION
            if (dataLname.isNotEmpty()) {
                if (dataLname.length <= 8) {
                } else {
                    LastN.error = "Last Name length must be less than or equal 8"
                    return@setOnClickListener
                }

            } else {
                LastN.error = "Last Name can't be empty"
                return@setOnClickListener
            }


            // EMAIL VALIDATION
            if (dataEmail.isNotEmpty()){
                if (validateEmail(dataEmail))
                {

                }
                else
                {
                    Email.error="Email is invalid!"
                    return@setOnClickListener
                }
            }else {
                Email.error = "Email field can't be empty!"
                return@setOnClickListener
            }



            // PASSWORD VALIDATION
            if (dataPass.isNotEmpty())
            {
                if(dataPass.length <= 8)
                {

                }
                else
                {
                    Password.error="Password must be less than or equal to 8"
                    return@setOnClickListener
                }
            }
            else
            {
                Password.error="Password field can't be empty!"
                return@setOnClickListener
            }


            // RADIO BUTTON VALIDATION
            if (radioBtnMale.isChecked() || radioBtnFemale.isChecked())
            {

            }
            else{
                Toast.makeText(this, "Plz choose gender", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }



            val i = Intent(this, Home::class.java)

            // To Remove very previous Activity
            i.flags=Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(i)
        }
    }

    private fun validateEmail(dataEmail:String): Boolean {

        return android.util.Patterns.EMAIL_ADDRESS.matcher(dataEmail).matches()
    }
}