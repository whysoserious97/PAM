package com.example.pam_lab1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import java.util.*

class Activity2 : AppCompatActivity() {

    companion object{
        const val Total_Count = "total_count"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)
        showRandom()
    }
    fun showRandom(){
        val count = intent.getIntExtra(Total_Count, 0)

        val random = Random()
        var randomInt = 0

        if (count>0){
            randomInt = random.nextInt(count + 1)
        }
        val textViewRandom = findViewById<TextView>(R.id.textView2)
        textViewRandom.text = randomInt.toString();
        val textViewLabel = findViewById<TextView>(R.id.textViewLabel)
        textViewLabel.text = getString(R.string.random_heading,count)
    }
}