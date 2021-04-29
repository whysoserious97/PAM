package com.example.pam_lab1.view

import android.os.Bundle
import android.view.View

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.pam_lab1.R
import com.example.pam_lab1.model.Destination
import com.example.pam_lab1.viewmodel.DestinationListViewModel
import kotlinx.android.synthetic.main.activity_destiny_create.*
import kotlinx.android.synthetic.main.activity_destiny_create.et_course
import kotlinx.android.synthetic.main.activity_destiny_create.et_description
import kotlinx.android.synthetic.main.activity_destiny_create.et_subject
import kotlinx.android.synthetic.main.activity_destiny_create.et_due
import kotlinx.android.synthetic.main.activity_destiny_create.view.*



class DestinationCreateActivity : AppCompatActivity() {

    lateinit var destinationViewModel: DestinationListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_destiny_create)


        // Show the Up button in the action bar.
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        destinationViewModel = ViewModelProvider(this).get(DestinationListViewModel::class.java)

        btn_add.setOnClickListener {
            val newDestination = Destination()
            newDestination.course = et_course.text.toString()
            newDestination.description = et_description.text.toString()

            newDestination.due =  findViewById<View>(R.id.et_due).et_due.text.toString() //et_due.text.toString()
            newDestination.subject = et_subject.text.toString()


            destinationViewModel.addDestination(newDestination)!!.observe(this, Observer { destination ->
                finish()
            })
        }
    }

}