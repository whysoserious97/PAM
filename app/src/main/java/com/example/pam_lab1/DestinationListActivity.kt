package com.example.pam_lab1

import android.content.Intent
import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pam_lab1.R
import kotlinx.android.synthetic.main.activity_destiny_list.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.math.abs

class DestinationListActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_destiny_list) //activity_destiny_list
        destiny_recycler_view.layoutManager = GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false)
       // gestureDetector = GestureDetector(this,this)
       // setSupportActionBar(toolbar)
       // toolbar.title = title

        fab.setOnClickListener {
            val intent = Intent(this@DestinationListActivity, DestinationCreateActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        CoroutineScope(IO).launch {
            loadDestinations()
        }

    }

    private suspend fun loadDestinations() {

        val destinationService = ServiceBuilder.buildService(DestinationService::class.java)

        val filter = HashMap<String, String>()
//        filter["country"] = "India"
//        filter["count"] = "1"

        val requestCall = destinationService.getDestinationList(filter)

        requestCall.enqueue(object: Callback<List<Destination>> {

            // If you receive a HTTP Response, then this method is executed
            // Your STATUS Code will decide if your Http Response is a Success or Error
            override fun onResponse(call: Call<List<Destination>>, response: Response<List<Destination>>) {
                if (response.isSuccessful) {
                    // Your status code is in the range of 200's
                    val destinationList = response.body()!!
                    val adapter = DestinationAdapter(destinationList.toMutableList())
                    destiny_recycler_view.adapter = adapter
                    var itemTouchHelper = ItemTouchHelper(SwipeToDelete(adapter))
                    itemTouchHelper.attachToRecyclerView(destiny_recycler_view)
                } else if(response.code() == 401) {
                    Toast.makeText(this@DestinationListActivity,
                        "Your session has expired. Please Login again.", Toast.LENGTH_LONG).show()
                } else { // Application-level failure
                    // Your status code is in the range of 300's, 400's and 500's
                    Toast.makeText(this@DestinationListActivity, "Failed to retrieve items", Toast.LENGTH_LONG).show()
                }
            }

            // Invoked in case of Network Error or Establishing connection with Server
            // or Error Creating Http Request or Error Processing Http Response
            override fun onFailure(call: Call<List<Destination>>, t: Throwable) {

                Toast.makeText(this@DestinationListActivity, "Error Occurred" + t.toString(), Toast.LENGTH_LONG).show()
            }
        })
    }

}