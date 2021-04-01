package com.example.pam_lab1

import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.pam_lab1.R
import kotlinx.android.synthetic.main.activity_destiny_create.*
import kotlinx.android.synthetic.main.activity_destiny_create.et_course
import kotlinx.android.synthetic.main.activity_destiny_create.et_description
import kotlinx.android.synthetic.main.activity_destiny_create.et_subject
import kotlinx.android.synthetic.main.activity_destiny_detail.*
import kotlinx.android.synthetic.main.list_item.*

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.math.abs

class DestinationCreateActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_destiny_create)

//        setSupportActionBar(toolbar)
        val context = this

        // Show the Up button in the action bar.
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        btn_add.setOnClickListener {
            val newDestination = Destination()
            newDestination.course = et_course.text.toString()
            newDestination.description = et_description.text.toString()
            newDestination.due = et_due.text.toString()
            newDestination.subject = et_subject.text.toString()

            val destinationService = ServiceBuilder.buildService(DestinationService::class.java)
            val requestCall = destinationService.addDestination(newDestination)

            requestCall.enqueue(object: Callback<Destination> {

                override fun onResponse(call: Call<Destination>, response: Response<Destination>) {
                    if (response.isSuccessful) {
                        finish() // Move back to DestinationListActivity
                      //  var newlyCreatedDestination = response.body() // Use it or ignore it
                        Toast.makeText(context, "Successfully Added", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(context, "Failed to add item", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<Destination>, t: Throwable) {
                    Toast.makeText(context, "Failed to add item", Toast.LENGTH_SHORT).show()
                }
            })
        }
    }

}