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

class DestinationCreateActivity : AppCompatActivity() , GestureDetector.OnGestureListener{

    lateinit var gestureDetector: GestureDetector
    var x1:Float = 0.0f
    var x2:Float = 0.0f
    var y1:Float = 0.0f
    var y2:Float = 0.0f

    companion object{
        const val MIN_DISTANCE = 150
    }

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
        gestureDetector = GestureDetector(this,this)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {

        gestureDetector.onTouchEvent(event)
        when (event?.action){

            0->{
                x1 = event.x
                y1 = event.y
            }
            1->{
                x2 = event.x
                y2 = event.y

                val valueX:Float = x2 - x1
                val valueY:Float= y2 - y1

                if(abs(valueX) > MainActivity.MIN_DISTANCE){
                    if(x2>x1){
                        this.finish()
                       // Toast.makeText(this,"Right Swipe",Toast.LENGTH_SHORT).show()
                    }
                    else{

                        //Toast.makeText(this,"Left Swipe",Toast.LENGTH_SHORT).show()
                    }
                }
                else if(abs(valueY) > MainActivity.MIN_DISTANCE){
                    if(y2>y1){
                        Toast.makeText(this,"Bottom Swipe",Toast.LENGTH_SHORT).show()
                    }
                    else{
                        Toast.makeText(this,"Top Swipe",Toast.LENGTH_SHORT).show()
                    }
                }
            }

        }





        return super.onTouchEvent(event)
    }




    override fun onDown(e: MotionEvent?): Boolean {

        return false
    }

    override fun onShowPress(e: MotionEvent?) {

        //return false
    }

    override fun onSingleTapUp(e: MotionEvent?): Boolean {
        return false
    }

    override fun onScroll(e1: MotionEvent?, e2: MotionEvent?, distanceX: Float, distanceY: Float): Boolean {

        return false
    }

    override fun onLongPress(e: MotionEvent?) {

    }

    override fun onFling(e1: MotionEvent?, e2: MotionEvent?, velocityX: Float, velocityY: Float): Boolean {
        return false
    }
}