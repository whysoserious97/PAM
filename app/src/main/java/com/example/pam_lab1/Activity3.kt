package com.example.pam_lab1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_auto_like.*
//import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class Activity3 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auto_like)
//        showInput()
        val exampleList = generateDummyList(30)
        recycler_view_toLike.adapter = ExampleAdapter(exampleList)
//        recycler_view_toLike.layoutManager = LinearLayoutManager(this)
        recycler_view_toLike.layoutManager = GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false)
        recycler_view_toLike.setHasFixedSize(true)
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
            val item = ExampleItem(drawable, "User $i", "Surname")
            list += item
        }
        return list
    }

    fun likeAll(view: View) {
        Toast.makeText(getApplicationContext(),"likeAll", Toast.LENGTH_SHORT).show();
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