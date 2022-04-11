package com.example.gb_4_3_list.data.model

import com.google.gson.annotations.SerializedName

data class ListingDto(
    @SerializedName("data")
    val data: ListingDataDto
)
