package com.example.pam_lab1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_not_following_back.*
//import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class Activity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_not_following_back)
//        showInput()
        val exampleList = generateDummyList(30)
        recycler_view.adapter = ExampleAdapter(exampleList)
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.setHasFixedSize(true)
    }
    private fun generateDummyList(size: Int): List<ExampleItem> {
        val list = ArrayList<ExampleItem>()
        for (i in 0 until size) {
//            val drawable = when (i % 3) {
//                0 -> R.drawable.ic_android
//                1 -> R.drawable.ic_audio
//                else -> R.drawable.ic_sun
//            }
            val drawable = R.drawable.ic_user
            val item = ExampleItem(drawable, "User $i", "Name_Surname")
            list += item
        }
        return list
    }

    fun unfollow(view: View) {
        Toast.makeText(getApplicationContext(),"unfollowed", Toast.LENGTH_SHORT).show();
    }
//    fun showInput(){
//        val received = intent.getStringExtra("input").toString()
////        act2_input.setText(received)
//
//    }
//
//    fun callback(view: View) {
//        val input = act2_input.text.toString()
//        val intent = Intent(this,MainActivity::class.java)
//        intent.putExtra("back",input)
//        startActivity(intent)
//    }
}