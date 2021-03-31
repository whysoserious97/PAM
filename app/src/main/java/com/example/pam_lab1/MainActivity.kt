package com.example.pam_lab1

import android.content.Intent
import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*

import kotlin.math.abs


class MainActivity : AppCompatActivity() ,GestureDetector.OnGestureListener{

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
        setContentView(R.layout.activity_main)

        //bottomNavigationView
        val navController = findNavController(R.id.fragment)

        val appBarConfiguration = AppBarConfiguration(setOf(R.id.firstFragment,R.id.second_Fragment))
        setupActionBarWithNavController(navController,appBarConfiguration)

        bottomNavigationView.setupWithNavController(navController)


        gestureDetector = GestureDetector(this,this)
    }

    fun getStarted(view: View?) {
        val intent = Intent(this, DestinationListActivity::class.java)
        startActivity(intent)
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

                if(abs(valueX) > MIN_DISTANCE){
                    if(x2>x1){
                        Toast.makeText(this,"Right Swipe",Toast.LENGTH_SHORT).show()
                    }
                    else{
                        getStarted(null)
                        //Toast.makeText(this,"Left Swipe",Toast.LENGTH_SHORT).show()
                    }
                }
                else if(abs(valueY)> MIN_DISTANCE){
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