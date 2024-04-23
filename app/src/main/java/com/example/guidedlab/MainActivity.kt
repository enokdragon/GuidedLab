package com.example.guidedlab

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    enum class LoginSuccess
    constructor(val intValue: Int){
        login(1),
        password(2),
        success(0)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val txtLogin = findViewById<TextView>(R.id.usernameEditView)
        val txtPassword = findViewById<TextView>(R.id.passwordEditView)
        val loginButton = findViewById<Button>(R.id.loginButton)

        loginButton.setOnClickListener{
            when(checkLogin(txtLogin.text.toString(), txtPassword.text.toString())){

                LoginSuccess.login -> {
                    Toast.makeText(applicationContext, getString(R.string.errMessageLogin),Toast.LENGTH_LONG).show()
                    txtLogin.requestFocus()
                }

                LoginSuccess.password -> {
                    Toast.makeText(applicationContext, getString(R.string.errMessagePassword),Toast.LENGTH_LONG).show()
                    txtPassword.requestFocus()
                }

                else -> {
                    Toast.makeText(applicationContext, "Welcome", Toast.LENGTH_LONG).show()
                    startActivity(Intent(this@MainActivity, MainClassList::class.java))
                }
            }
        }
    }
    fun checkLogin(txtLogin: String, txtPassword: String): LoginSuccess {
        val holdLogin = "enok"
        val holdPass = "password"

        if(holdLogin != txtLogin){
            return LoginSuccess.login
        }
        return if (holdPass != txtPassword){
            LoginSuccess.password
        }else LoginSuccess.success
    }
}