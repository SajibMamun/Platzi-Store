package com.example.platzistore.network

import com.example.platzistore.model.data.login.RequestLogin
import com.example.platzistore.model.data.login.ResponseLogin
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {

@POST("auth/login")
    suspend fun login(@Body requestLogin: RequestLogin): Response<ResponseLogin>


}