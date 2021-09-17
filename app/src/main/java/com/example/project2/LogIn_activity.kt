package com.example.project2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LogIn_activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        val login_Btn = findViewById<Button>(R.id.login_btn)




        val forget_Password = findViewById<TextView>(R.id.ForgotPass)

            forget_Password.setOnClickListener()
            {
                val i = Intent(this,ForgotPass_activity::class.java)
                startActivity(i)
            }



        val signUp_lnk = findViewById<Button>(R.id.SignUp_link)

           signUp_lnk.setOnClickListener()
           {
               val i = Intent(this,SignUp_activity::class.java)
               startActivity(i)
           }




        login_Btn.setOnClickListener()
        {
            val dataUserName:String = UserN_In.text.toString()
            val dataPassword:String = UserP_In.text.toString()



        // USERNAME VALIDATION
            if (dataUserName.isNotEmpty())
            {
                    if (Validate_Username())
                     {

                     } else
                {
                    UserN_In.error="Username is invalid!"
                    return@setOnClickListener
                }

            }
            else
            {
                UserN_In.error="Username is required!"
                return@setOnClickListener
            }



        // PASSWORD VALIDATION
            if(dataPassword.isNotEmpty())
            {

            }
            else
            {
                UserP_In.error="Password is required"
                return@setOnClickListener
            }


        // CHECKBOX VALIDATION
            if(CheckBox_id.isChecked)
            {

            }
            else
            {
                Toast.makeText(this, "Plz agree all terms and services", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val i = Intent(this,Home::class.java)

            // To Remove very previous Activity
            i.flags=Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK

            // To send data from one Activity to another
            i.putExtra("message",dataUserName)

            startActivity(i)

        }

    }


    private fun Validate_Username(): Boolean
    {
        return UserN_In.length() > 5 && UserN_In.length() <= 15

    }




}




