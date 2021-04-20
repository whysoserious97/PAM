package com.example.pam_lab1.repository

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.pam_lab1.model.Destination
import com.example.pam_lab1.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object DestinationRepository {

    val destinationList = MutableLiveData<List<Destination>>()

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

                val destinationList = response.body()!!
                //return destinationList
               // val msg = data!!.message

               // serviceSetterGetter.value = ServicesSetterGetter(msg)
            }
        })
        return destinationList
       // return serviceSetterGetter
    }
}