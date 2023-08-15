package com.example.platzistore.ui.auth.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.platzistore.model.data.login.RequestLogin
import com.example.platzistore.model.data.login.ResponseLogin
import com.example.platzistore.model.repositories.AuthRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private  val  repo: AuthRepo): ViewModel(){

private val _loginresponse=MutableLiveData<ResponseLogin>()

    val loginresponse:LiveData<ResponseLogin> = _loginresponse





fun login(requestLogin: RequestLogin){

    viewModelScope.launch {

        _loginresponse.postValue(repo.login(requestLogin))

    }


}


}