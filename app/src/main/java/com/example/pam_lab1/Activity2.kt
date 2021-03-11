package com.example.pam_lab1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_2.*
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class Activity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)
        showInput()
    }
    fun showInput(){
        val received = intent.getStringExtra("input").toString()
        act2_input.setText(received)

    }

    fun callback(view: View) {
        val input = act2_input.text.toString()
        val intent = Intent(this,MainActivity::class.java)
        intent.putExtra("back",input)
        startActivity(intent)
    }
}