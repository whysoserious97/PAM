package com.example.pam_lab1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_not_following_back.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(getApplicationContext(),"Come back later", Toast.LENGTH_SHORT).show();
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        if(intent.hasExtra("back")){
//            displayInput()
//        }
//        val exampleList = generateDummyList(30)
//        recycler_view.adapter = ExampleAdapter(exampleList)
//        recycler_view.layoutManager = LinearLayoutManager(this)
//        recycler_view.setHasFixedSize(true)
    }
//    private fun generateDummyList(size: Int): List<ExampleItem> {
//        val list = ArrayList<ExampleItem>()
//        for (i in 0 until size) {
////            val drawable = when (i % 3) {
////                0 -> R.drawable.ic_android
////                1 -> R.drawable.ic_audio
////                else -> R.drawable.ic_sun
////            }
//            val drawable = R.drawable.ic_user
//            val item = ExampleItem(drawable, "User $i", "Name_Surname")
//            list += item
//        }
//        return list
//    }
//    fun displayInput(){
//        val received = intent.getStringExtra("back").toString()
//        returned.setText(received)
//    }
    fun toUnfollow(view: View){
//        val input = inputText.text.toString()
        val intent = Intent(this,Activity2::class.java)
//        intent.putExtra("input",input)
        startActivity(intent)
    }

    fun toLike(view: View) {
        val intent = Intent(this,Activity3::class.java)
        startActivity(intent)
    }
}