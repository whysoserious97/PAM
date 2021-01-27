package com.example.pam_lab1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun updateNumber(view: View){
        val textView = findViewById<TextView>(R.id.number)
        val countString = textView.text.toString()
        var count : Int = Integer.parseInt(countString)
        count++
        textView.text = count.toString()
    }
    fun randomMe(view: View){
        val randomIntent = Intent(this,Activity2::class.java)

        val textView = findViewById<TextView>(R.id.number)
        val countString = textView.text.toString()

        val count = Integer.parseInt(countString)

        randomIntent.putExtra(Activity2.Total_Count,count)


        startActivity(randomIntent)
    }
}