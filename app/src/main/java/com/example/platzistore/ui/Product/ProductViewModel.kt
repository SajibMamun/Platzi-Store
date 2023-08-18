package com.example.platzistore.ui.Product

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.platzistore.model.data.login.RequestLogin
import com.example.platzistore.model.data.login.ResponseLogin
import com.example.platzistore.model.data.product.ResponseProduct
import com.example.platzistore.model.data.profile.ResponseProfile
import com.example.platzistore.model.repositories.AuthRepo
import com.example.platzistore.model.repositories.ProductRepo
import com.example.platzistore.model.repositories.UserRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(private val repo: ProductRepo) : ViewModel() {

    private val _response = MutableLiveData<Response<List<ResponseProduct>>>()

    val productResponse: LiveData<Response<List<ResponseProduct>>> = _response


    fun getAllProduct() {

        viewModelScope.launch {

            _response.postValue(repo.getAllProduct())

        }

    }



}