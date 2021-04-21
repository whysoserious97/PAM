package com.example.pam_lab1.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pam_lab1.view.DestinationDetailActivity
import com.example.pam_lab1.R
import com.example.pam_lab1.retrofit.ServiceBuilder
import com.example.pam_lab1.model.Destination
import com.example.pam_lab1.retrofit.DestinationService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DestinationAdapter(var destinationList: MutableList<Destination>) : RecyclerView.Adapter<DestinationAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.destination = destinationList[position]
        holder.tvxSubject.text = destinationList[position].subject
        holder.tvxDue.text = destinationList[position].due
        holder.tvxCourse.text = destinationList[position].course

        holder.itemView.setOnClickListener { v ->
            val context = v.context
            val intent = Intent(context, DestinationDetailActivity::class.java)
            intent.putExtra(DestinationDetailActivity.ARG_ITEM_ID, holder.destination!!.id)

            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return destinationList.size
    }
    fun deleteItem(pos:Int){
        delete(destinationList[pos].id)
        destinationList.removeAt(pos)
        notifyItemRemoved(pos)
    }
    fun delete(id:Int){
        val destinationService = ServiceBuilder.buildService(DestinationService::class.java)
        val requestCall = destinationService.deleteDestination(id)

        requestCall.enqueue(object : Callback<Unit> {

            override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
                if (response.isSuccessful) {
                    // finish() // Move back to DestinationListActivity
                    // Toast.makeText(this@, "Successfully Deleted", Toast.LENGTH_SHORT).show()
                } else {
                    //  Toast.makeText(this@DestinationDetailActivity, "Failed to Delete", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<Unit>, t: Throwable) {
                //  Toast.makeText(this@DestinationDetailActivity, "Failed to Delete", Toast.LENGTH_SHORT).show()
            }
        })
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val tvxCourse: TextView = itemView.findViewById(R.id.tvx_course)
        val tvxDue: TextView = itemView.findViewById(R.id.tvx_due)
        val tvxSubject: TextView = itemView.findViewById(R.id.tvx_subject)
        var destination: Destination? = null

        override fun toString(): String {
            return """${super.toString()} '${tvxSubject.text}'"""
        }
    }
}