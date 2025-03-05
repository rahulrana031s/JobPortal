package com.example.jobportal.ui.api

import com.example.jobportal.ui.models.UserData
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface PortalData {

    @GET("bb11aecd-ba61-44b9-9e2c-beabc442d818")
    suspend fun getPortalData(): Response<UserData>

}