package com.example.platzistore.ui.auth.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.platzistore.model.data.login.RequestLogin
import com.example.platzistore.model.data.login.ResponseLogin
import com.example.platzistore.model.data.profile.ResponseProfile
import com.example.platzistore.model.repositories.AuthRepo
import com.example.platzistore.model.repositories.UserRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(private  val  repo: UserRepo): ViewModel(){

private val _response=MutableLiveData<Response<ResponseProfile>>()

    val profileResponse:LiveData<Response<ResponseProfile>> = _response





fun getProfile(){

    viewModelScope.launch {

        _response.postValue(repo.userProfile())

    }


}


}