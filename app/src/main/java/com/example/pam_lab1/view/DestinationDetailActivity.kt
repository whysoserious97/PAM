package com.example.pam_lab1.view

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.pam_lab1.model.Destination
import com.example.pam_lab1.retrofit.DestinationService
import com.example.pam_lab1.viewmodel.DestinationListViewModel
import kotlinx.android.synthetic.main.activity_destiny_detail.*
import kotlinx.android.synthetic.main.activity_destiny_list.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*
import androidx.lifecycle.Observer
import com.example.pam_lab1.R
import com.example.pam_lab1.retrofit.ServiceBuilder


class DestinationDetailActivity : AppCompatActivity() {



    private var datePickerDialog: DatePickerDialog? = null
    lateinit var destinationViewModel: DestinationListViewModel
   // private var dateButton: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_destiny_detail)
        initDatePicker();
       // var dateButton = findViewById(R.id.et_due);
       // et_due.setText(getTodaysDate());
        //setSupportActionBar(detail_toolbar)
        // Show the Up button in the action bar.
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val bundle: Bundle? = intent.extras

        if (bundle?.containsKey(ARG_ITEM_ID)!!) {

            val id = intent.getIntExtra(ARG_ITEM_ID, 0)

            destinationViewModel = ViewModelProvider(this).get(DestinationListViewModel::class.java)
            destinationViewModel.getDestination(id)!!.observe(this, Observer { destination ->

                et_course.setText(destination.course)
                et_description.setText(destination.description)
                et_subject.setText(destination.subject)
                et_due.setText(destination.due)

            })

            initUpdateButton(id)

            initDeleteButton(id)
        }
    }

    private fun getTodaysDate(): String? {
        val cal: Calendar = Calendar.getInstance()
        val year: Int = cal.get(Calendar.YEAR)
        var month: Int = cal.get(Calendar.MONTH)
        month = month + 1
        val day: Int = cal.get(Calendar.DAY_OF_MONTH)
        return makeDateString(day, month, year)
    }
    private fun initDatePicker() {
        val dateSetListener = OnDateSetListener { datePicker, year, month, day ->
            var month = month
            month = month + 1
            val date: String = makeDateString(day, month, year)
            et_due!!.text = date
        }
        val cal: Calendar = Calendar.getInstance()
        val year: Int = cal.get(Calendar.YEAR)
        val month: Int = cal.get(Calendar.MONTH)
        val day: Int = cal.get(Calendar.DAY_OF_MONTH)
        val style: Int = AlertDialog.THEME_HOLO_LIGHT
        datePickerDialog = DatePickerDialog(this, style, dateSetListener, year, month, day)
        //datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());
    }
    private fun makeDateString(day: Int, month: Int, year: Int): String {
        return getMonthFormat(month) + " " + day + " " + year
    }

    private fun getMonthFormat(month: Int): String {
        if (month == 1) return "JAN"
        if (month == 2) return "FEB"
        if (month == 3) return "MAR"
        if (month == 4) return "APR"
        if (month == 5) return "MAY"
        if (month == 6) return "JUN"
        if (month == 7) return "JUL"
        if (month == 8) return "AUG"
        if (month == 9) return "SEP"
        if (month == 10) return "OCT"
        if (month == 11) return "NOV"
        return if (month == 12) "DEC" else "JAN"

        //default should never happen
    }

    fun openDatePicker(view: View?) {
        datePickerDialog!!.show()
    }

    private fun loadDetails(id: Int) {

        val destinationService = ServiceBuilder.buildService(DestinationService::class.java)
        val requestCall = destinationService.getDestination(id)

        requestCall.enqueue(object : retrofit2.Callback<Destination> {

            override fun onResponse(call: Call<Destination>, response: Response<Destination>) {

                if (response.isSuccessful) {
                    val destination = response.body()
                    destination?.let {
                        et_course.setText(destination.course)
                        et_description.setText(destination.description)
                        et_subject.setText(destination.subject)
                        et_due.setText(destination.due)

                        //collapsing_toolbar.title = destination.city
                    }
                } else {
                    Toast.makeText(this@DestinationDetailActivity, "Failed to retrieve details", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<Destination>, t: Throwable) {
                Toast.makeText(this@DestinationDetailActivity, "Failed to retrieve details " + t.toString(), Toast.LENGTH_SHORT).show()
            }
        })
    }


    private fun initUpdateButton(id: Int) {

        btn_update.setOnClickListener {

            val course = et_course.text.toString()
            val description = et_description.text.toString()
            val subject = et_subject.text.toString()
            val due = et_due.text.toString()

            val destinationService = ServiceBuilder.buildService(DestinationService::class.java)
            val requestCall = destinationService.updateDestination(id, course, description, subject,due)

            requestCall.enqueue(object : Callback<Destination> {

                override fun onResponse(call: Call<Destination>, response: Response<Destination>) {
                    if (response.isSuccessful) {
                        finish() // Move back to DestinationListActivity
                        var updatedDestination = response.body() // Use it or ignore It
                        Toast.makeText(this@DestinationDetailActivity,
                                "Item Updated Successfully", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this@DestinationDetailActivity,
                                "Failed to update item", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<Destination>, t: Throwable) {
                    Toast.makeText(this@DestinationDetailActivity,
                            "Failed to update item", Toast.LENGTH_SHORT).show()
                }
            })
        }
    }

    fun delete(id: Int){
        val destinationService = ServiceBuilder.buildService(DestinationService::class.java)
        val requestCall = destinationService.deleteDestination(id)

        requestCall.enqueue(object : Callback<Unit> {

            override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
                if (response.isSuccessful) {
                    finish() // Move back to DestinationListActivity
                    Toast.makeText(this@DestinationDetailActivity, "Successfully Deleted", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this@DestinationDetailActivity, "Failed to Delete", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<Unit>, t: Throwable) {
                Toast.makeText(this@DestinationDetailActivity, "Failed to Delete", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun initDeleteButton(id: Int) {

        btn_delete.setOnClickListener {

            delete(id)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == android.R.id.home) {
            navigateUpTo(Intent(this, DestinationListActivity::class.java))
            return true
        }
        return super.onOptionsItemSelected(item)
    }


    companion object {
        const val ARG_ITEM_ID = "item_id"
    }


}