package com.example.platzistore.model.repositories

import com.example.platzistore.model.data.login.RequestLogin
import com.example.platzistore.model.data.login.ResponseLogin
import com.example.platzistore.model.data.register.RequestRegister
import com.example.platzistore.model.data.register.ResponseRegister
import com.example.platzistore.network.AuthService
import retrofit2.Response
import javax.inject.Inject

class AuthRepo @Inject constructor(val authService: AuthService) {



    //we can do it
 suspend   fun login(requestLogin: RequestLogin): ResponseLogin{
       val response = authService.login(requestLogin)
        return response.body()!!
    }


    suspend   fun register(requestRegister: RequestRegister): ResponseRegister{
        val response = authService.register(requestRegister)
        return response.body()!!
    }

}