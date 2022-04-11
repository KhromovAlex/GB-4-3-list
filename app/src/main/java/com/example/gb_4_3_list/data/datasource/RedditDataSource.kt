package com.example.gb_4_3_list.data.datasource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.gb_4_3_list.data.api.RedditApi
import com.example.gb_4_3_list.domain.entity.Post
import retrofit2.HttpException
import java.io.IOException

class RedditDataSource(
    private val redditApi: RedditApi
) : PagingSource<String, Post>() {
    override fun getRefreshKey(state: PagingState<String, Post>): String? {
        return state.pages.lastOrNull()?.nextKey
    }

    override suspend fun load(params: LoadParams<String>): LoadResult<String, Post> {
        val key = params.key ?: ""
        return try {
            val res = redditApi.getPosts(key)
            val items = res.data.children.map {
                Post(
                    id = it.data.id,
                    title = it.data.title,
                    numComments = it.data.numComments,
                )
            }
            LoadResult.Page(
                data = items,
                prevKey = res.data.before,
                nextKey = res.data.after
            )
        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }

}
