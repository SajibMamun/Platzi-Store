package com.example.platzistore.network

import com.example.platzistore.model.data.login.RequestLogin
import com.example.platzistore.model.data.login.ResponseLogin
import com.example.platzistore.model.data.profile.ResponseProfile
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface UserService {
    @Headers("Accept: Bearer ")
    @POST("auth/profile")
    suspend fun userprofile(): Response<ResponseProfile>
}