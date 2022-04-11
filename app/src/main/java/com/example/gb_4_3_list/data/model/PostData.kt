package com.example.gb_4_3_list.data.model

import com.google.gson.annotations.SerializedName

data class PostData(
    @SerializedName("id")
    val id: String,
    @SerializedName("num_comments")
    val numComments: Int,
    @SerializedName("title")
    val title: String
)
