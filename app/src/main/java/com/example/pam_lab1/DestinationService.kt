package com.example.pam_lab1

import retrofit2.Call
import retrofit2.http.*
import javax.security.auth.Subject

interface DestinationService {

    @GET("task")
    fun getDestinationList(@QueryMap filter: HashMap<String, String>): Call<List<Destination>>

    @GET("task/{id}")
    fun getDestination(@Path("id") id: Int): Call<Destination>

    @POST("task")
    fun addDestination(@Body newDestination: Destination): Call<Destination>

    @FormUrlEncoded
    @PUT("task/{id}")
    fun updateDestination(
            @Path("id") id: Int,
            @Field("course") course: String,
            @Field("description") desc: String,
            @Field("subject") subject: String,
            @Field("due") due: String
    ): Call<Destination>

    @DELETE("task/{id}")
    fun deleteDestination(@Path("id") id: Int): Call<Unit>
}