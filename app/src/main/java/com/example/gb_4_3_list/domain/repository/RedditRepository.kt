package com.example.gb_4_3_list.domain.repository

import androidx.paging.PagingData
import com.example.gb_4_3_list.domain.entity.Post
import kotlinx.coroutines.flow.Flow

interface RedditRepository {
    fun getPosts(): Flow<PagingData<Post>>
}
