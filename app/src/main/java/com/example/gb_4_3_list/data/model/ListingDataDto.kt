package com.example.gb_4_3_list.data.model

import com.google.gson.annotations.SerializedName

data class ListingDataDto(
    @SerializedName("after")
    val after: String?,
    @SerializedName("children")
    val children: List<Post>,
    @SerializedName("before")
    val before: String?
)
