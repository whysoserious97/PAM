package com.example.pam_lab1

import android.content.Intent
import android.os.Bundle

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ItemTouchHelper
import com.example.pam_lab1.model.Destination
import com.example.pam_lab1.retrofit.DestinationService
import kotlinx.android.synthetic.main.activity_destiny_list.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DestinationListActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_destiny_list) //activity_destiny_list
        destiny_recycler_view.layoutManager = GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false)


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


        val requestCall = destinationService.getDestinationList(filter)

        requestCall.enqueue(object: Callback<List<Destination>> {

            override fun onResponse(call: Call<List<Destination>>, response: Response<List<Destination>>) {
                if (response.isSuccessful) {

                    val destinationList = response.body()!!
                    val adapter = DestinationAdapter(destinationList.toMutableList())
                    destiny_recycler_view.adapter = adapter
                    var itemTouchHelper = ItemTouchHelper(SwipeToDelete(adapter))
                    itemTouchHelper.attachToRecyclerView(destiny_recycler_view)
                } else if(response.code() == 401) {
                    Toast.makeText(this@DestinationListActivity,
                        "Your session has expired. Please Login again.", Toast.LENGTH_LONG).show()
                } else { // Application-level failure

                    Toast.makeText(this@DestinationListActivity, "Failed to retrieve items", Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<List<Destination>>, t: Throwable) {

                Toast.makeText(this@DestinationListActivity, "Error Occurred" + t.toString(), Toast.LENGTH_LONG).show()
            }
        })
    }

}