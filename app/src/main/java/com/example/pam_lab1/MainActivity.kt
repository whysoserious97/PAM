package com.example.pam_lab1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_2.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(getApplicationContext(),"Come back later", Toast.LENGTH_SHORT).show();
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if(intent.hasExtra("back")){
            displayInput()
        }
    }
    fun displayInput(){
        val received = intent.getStringExtra("back").toString()
        returned.setText(received)
    }
    fun next(view: View){
        val input = inputText.text.toString()
        val intent = Intent(this,Activity2::class.java)
        intent.putExtra("input",input)
        startActivity(intent)
    }
}