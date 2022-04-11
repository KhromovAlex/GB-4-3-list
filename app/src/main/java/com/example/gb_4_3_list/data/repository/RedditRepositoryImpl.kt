package com.example.gb_4_3_list.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.gb_4_3_list.data.datasource.RedditDataSource
import com.example.gb_4_3_list.domain.entity.Post
import com.example.gb_4_3_list.domain.repository.RedditRepository
import kotlinx.coroutines.flow.Flow

class RedditRepositoryImpl(
    val redditDataSource: RedditDataSource
): RedditRepository {
    override fun getPosts(): Flow<PagingData<Post>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10,
            ),
            initialKey = "",
            pagingSourceFactory = { redditDataSource }
        ).flow
    }
}
