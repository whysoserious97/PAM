package com.example.pam_lab1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.pam_lab1.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

    }
    fun loggedIn(view: View){
//        val input = inputText.text.toString()
        val intent = Intent(this,MainActivity::class.java)
//        intent.putExtra("input",input)
        startActivity(intent)
    }
}
