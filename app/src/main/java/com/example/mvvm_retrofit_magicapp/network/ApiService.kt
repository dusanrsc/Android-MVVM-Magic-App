package com.example.mvvm_retrofit_magicapp.network

import com.example.mvvm_retrofit_magicapp.model.FeedbackModel
import com.example.mvvm_retrofit_magicapp.model.HouseData
import com.example.mvvm_retrofit_magicapp.model.WizardData
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {

    @GET(value = "/houses")
    suspend fun getHouseData(): List<HouseData>

    @Headers("accept: text/plain")
    @GET(value = "/wizards")
    suspend fun getWizardData(
        @Query("FirstName") firstName: String? = null,
        @Query("LastName") lastName: String? = null
    ): List<WizardData>

    @Headers("accept: text/plain", "Content-Type: application/json-patch+json")
    @POST(value = "/Feedback")
    suspend fun submitFeedback(@Body feedback: FeedbackModel): Response<Void>
}