package com.example.pam_lab1.adapter

import com.example.pam_lab1.model.Destination
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class DestinationAdapterTest {

//    lateinit var adapter:DestinationAdapter
//    @Before
//    fun setup(){
//        var allTasks = ArrayList<Destination>()
//        // create and add plants to our collection.
//        var task1 = Destination(0, "PAM", "Description1")
//        allTasks.add(task1)
//        var task2 = Destination(1, "RTP", "Description2")
//        allTasks.add(task2)
//        var task3 = Destination(2, "PS", "Lab 4")
//        allTasks.add(task3)
//
//        adapter = DestinationAdapter(allTasks)
//    }


    @Test
    fun getItemCount() {
        var allTasks = ArrayList<Destination>()
        // create and add plants to our collection.
        var task1 = Destination(0, "PAM", "Description1")
        allTasks.add(task1)
        var task2 = Destination(1, "RTP", "Description2")
        allTasks.add(task2)
        var task3 = Destination(2, "PS", "Lab 4")
        allTasks.add(task3)

        var adapter = DestinationAdapter(allTasks)
        assertEquals(3, adapter.itemCount)
    }

//    @Test
//    fun deleteItem() {
//        adapter.deleteItem(0)
//        assertEquals(2,adapter.itemCount)
//    }

//    @Test
//    fun delete() {
//    }
//
//    @Test
//    fun getDestinationList() {
//    }
//
//    @Test
//    fun setDestinationList() {
//    }
}