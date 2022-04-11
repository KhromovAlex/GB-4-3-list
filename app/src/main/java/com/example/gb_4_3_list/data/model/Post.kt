package com.example.gb_4_3_list.data.model

import com.google.gson.annotations.SerializedName

data class Post(
    @SerializedName("data")
    val data: PostData
)
