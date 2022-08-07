package com.example.jobportal.ui.viewModal

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jobportal.ui.models.UserData
import com.example.jobportal.ui.repo.PortalRepository
import com.example.jobportal.ui.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class PortalViewModal @Inject constructor(val repo: PortalRepository):ViewModel() {


    val userResponseLiveData : LiveData<UserData>
        get() = repo.userLiveData

    fun getUserInfo(){
        viewModelScope.launch {
            repo.getUserData()
        }
    }

}