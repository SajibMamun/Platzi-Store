package com.example.platzistore.ui.auth.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.platzistore.model.data.login.RequestLogin
import com.example.platzistore.model.data.login.ResponseLogin
import com.example.platzistore.model.data.register.RequestRegister
import com.example.platzistore.model.data.register.ResponseRegister
import com.example.platzistore.model.repositories.AuthRepo
import kotlinx.coroutines.launch
import javax.inject.Inject

class RegisterViewModel@Inject constructor(private  val  repo: AuthRepo): ViewModel(){

    private val _registerresponse= MutableLiveData<ResponseRegister>()

    val registerresponse: LiveData<ResponseRegister> = _registerresponse





    fun register(request: RequestRegister){

        viewModelScope.launch {

            _registerresponse.postValue(repo.register(request))

        }


    }}