package com.example.pam_lab1.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pam_lab1.model.Destination
import com.example.pam_lab1.repository.DestinationRepository

class DestinationListViewModel : ViewModel() {

    var servicesLiveData: MutableLiveData<List<Destination>>? = null

    fun getDestinations(filter: HashMap<String,String>) : LiveData<List<Destination>>? {
        //val filter = HashMap<String, String>()
        servicesLiveData = DestinationRepository.getServicesApiCall(filter)
        return servicesLiveData
    }

}