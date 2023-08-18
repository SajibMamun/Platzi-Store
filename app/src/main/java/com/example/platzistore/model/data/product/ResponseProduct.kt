package com.example.platzistore.model.data.product


import com.example.platzistore.model.data.category.Category
import com.google.gson.annotations.SerializedName

data class ResponseProduct(
    @SerializedName("category")
    var category: Category?,
    @SerializedName("creationAt")
    var creationAt: String?,
    @SerializedName("description")
    var description: String?,
    @SerializedName("id")
    var id: Int,
    @SerializedName("images")
    var images: List<String?>?,
    @SerializedName("price")
    var price: Int?,
    @SerializedName("title")
    var title: String?,
    @SerializedName("updatedAt")
    var updatedAt: String?
)