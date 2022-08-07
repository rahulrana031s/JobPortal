package com.example.jobportal.ui.repo

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.jobportal.R
import com.example.jobportal.ui.api.PortalData
import com.example.jobportal.ui.models.UserData
import com.example.jobportal.ui.utils.Constants.TAG
import com.example.jobportal.ui.utils.NetworkResult
import org.json.JSONObject
import retrofit2.Response
import javax.inject.Inject

class PortalRepository@Inject constructor(private val portalData: PortalData) {

    private val _userResponseData = MutableLiveData<UserData>()
    val userLiveData : LiveData<UserData>
        get() = _userResponseData

    suspend fun getUserData(){
        val response = portalData.getPortalData()
        _userResponseData.postValue(response.body())
        Log.d(TAG,response.body().toString())
    }


}