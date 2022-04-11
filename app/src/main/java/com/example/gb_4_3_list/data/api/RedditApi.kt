package com.example.gb_4_3_list.data.api

import com.example.gb_4_3_list.data.model.ListingDto
import retrofit2.http.GET
import retrofit2.http.Query

interface RedditApi {
    @GET("/r/aww/hot.json")
    suspend fun getPosts(@Query("after") after: String): ListingDto
}
