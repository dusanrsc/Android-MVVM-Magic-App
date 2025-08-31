package com.example.mvvm_retrofit_magicapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvm_retrofit_magicapp.model.FeedbackModel
import com.example.mvvm_retrofit_magicapp.network.RetrofitClient
import kotlinx.coroutines.launch
import java.util.UUID

class HarryPotterViewModel: ViewModel() {
    private val _harryPotterData = MutableLiveData<String>("No Data!")
    val harryPotterData: LiveData<String> get() = _harryPotterData
    private val suggestion = FeedbackModel(
        feedbackType = "Suggestion",
        feedback = "Rename The Wizzard Endpoints!",
        entityId = UUID.randomUUID().toString())

    init {
        viewModelScope.launch {
            getHouse()
            //getWizard("Fleamont", "Potter")
            //postFeedback(feedback = suggestion)
        }
    }

    private suspend fun getHouse() {
        _harryPotterData.value = RetrofitClient.apiService.getHouseData().toString()
    }

    private suspend fun getWizard(firstName: String? = null, lastName: String? = null) {
        _harryPotterData.value = RetrofitClient.apiService.getWizardData(firstName, lastName).toString()
    }

    private suspend fun postFeedback(feedback: FeedbackModel) {
        _harryPotterData.value = RetrofitClient.apiService.submitFeedback(feedback).toString()
    }
}