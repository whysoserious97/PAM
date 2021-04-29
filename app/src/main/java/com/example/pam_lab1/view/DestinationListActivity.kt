package com.example.pam_lab1.view

import android.content.Intent
import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ItemTouchHelper
import com.example.pam_lab1.R
import com.example.pam_lab1.adapter.DestinationAdapter
import com.example.pam_lab1.utils.SwipeToDelete
import com.example.pam_lab1.viewmodel.DestinationListViewModel
import kotlinx.android.synthetic.main.activity_destiny_list.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class DestinationListActivity : AppCompatActivity() {

    lateinit var mainActivityViewModel: DestinationListViewModel

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
            loadDestinations()

    }

    private fun loadDestinations() {

        val filter = HashMap<String, String>()

        mainActivityViewModel = ViewModelProvider(this).get(DestinationListViewModel::class.java)

        mainActivityViewModel.getDestinations(filter)!!.observe(this, Observer { destinationList ->

                    val adapter = DestinationAdapter(destinationList.toMutableList())
                    destiny_recycler_view.adapter = adapter

                    var itemTouchHelper = ItemTouchHelper(SwipeToDelete(adapter))
                    itemTouchHelper.attachToRecyclerView(destiny_recycler_view)

        })
    }

}