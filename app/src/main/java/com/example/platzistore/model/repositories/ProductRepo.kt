package com.example.platzistore.model.repositories

import com.example.platzistore.model.data.login.RequestLogin
import com.example.platzistore.model.data.login.ResponseLogin
import com.example.platzistore.model.data.product.ResponseProduct
import com.example.platzistore.model.data.register.RequestRegister
import com.example.platzistore.model.data.register.ResponseRegister
import com.example.platzistore.network.AuthService
import com.example.platzistore.network.ProductService
import retrofit2.Response
import javax.inject.Inject

class ProductRepo @Inject constructor(val service: ProductService) {



    //we can do it
    suspend   fun getAllProduct(): Response<List<ResponseProduct> >{
        return service.getAllProducts()

    }

}