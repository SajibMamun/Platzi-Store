package com.example.platzistore.model.repositories


import com.example.platzistore.model.data.profile.ResponseProfile

import com.example.platzistore.network.UserService
import retrofit2.Response
import javax.inject.Inject

class UserRepo @Inject constructor(val userService: UserService) {



    //we can do it
    suspend   fun userProfile(): Response<ResponseProfile> {
        return userService.userprofile()

    }


}