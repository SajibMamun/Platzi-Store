package com.example.platzistore.network

import com.example.platzistore.model.data.login.RequestLogin
import com.example.platzistore.model.data.login.ResponseLogin
import com.example.platzistore.model.data.product.ResponseProduct
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ProductService {

    @GET("products")
    suspend fun getAllProducts():Response<List<ResponseProduct>>

}