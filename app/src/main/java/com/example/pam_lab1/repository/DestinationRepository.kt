package com.example.pam_lab1.repository

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.pam_lab1.model.Destination
import com.example.pam_lab1.retrofit.RetrofitClient
import kotlinx.android.synthetic.main.activity_destiny_detail.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object DestinationRepository {

    val destinationList = MutableLiveData<List<Destination>>()
    val destination = MutableLiveData<Destination>()

    fun getServicesApiCall(filter: HashMap<String, String>): MutableLiveData<List<Destination>> {

        val call = RetrofitClient.apiInterface.getDestinationList(filter)

        call.enqueue(object: Callback<List<Destination>> {
            override fun onFailure(call: Call<List<Destination>>, t: Throwable) {
                Log.v("DEBUG : ", t.message.toString())
            }

            override fun onResponse(
                call: Call<List<Destination>>,
                response: Response<List<Destination>>
            ) {
                Log.v("DEBUG : ", response.body().toString())

                destinationList.value = response.body()!!

            }
        })
        return destinationList

    }
    /////////////////////////////////////////////
    fun loadDetails(id: Int): MutableLiveData<Destination> {

        val call = RetrofitClient.apiInterface.getDestination(id)

        call.enqueue(object: Callback<Destination> {
            override fun onFailure(call: Call<Destination>, t: Throwable) {
                Log.v("DEBUG : ", t.message.toString())
            }

            override fun onResponse(
                    call: Call<Destination>,
                    response: Response<Destination>
            ) {
                Log.v("DEBUG : ", response.body().toString())

                destination.value = response.body()!!
            }
        })
        return destination
}
    ///////////////////////////////////////////
    fun addDestination(dest: Destination): MutableLiveData<Destination> {

        val call = RetrofitClient.apiInterface.addDestination(dest)

        call.enqueue(object: Callback<Destination> {
            override fun onFailure(call: Call<Destination>, t: Throwable) {
                Log.v("DEBUG : ", t.message.toString())
            }

            override fun onResponse(
                    call: Call<Destination>,
                    response: Response<Destination>
            ) {
                Log.v("DEBUG : ", response.body().toString())
                destination.value = response.body()!!
                //destination.value = response.body()!!
            }
        })
        return destination
    }
}