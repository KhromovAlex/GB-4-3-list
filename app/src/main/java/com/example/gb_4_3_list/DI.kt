package com.example.gb_4_3_list

import com.example.gb_4_3_list.data.api.RedditApi
import com.example.gb_4_3_list.data.datasource.RedditDataSource
import com.example.gb_4_3_list.data.repository.RedditRepositoryImpl
import com.example.gb_4_3_list.domain.repository.RedditRepository
import com.example.gb_4_3_list.presentation.viewmodel.RedditListViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object DI {

    private const val BASE_URL = "https://www.reddit.com/"

    fun getModule() = module {
        single<RedditApi> {
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(
                    OkHttpClient.Builder()
                        .addInterceptor(HttpLoggingInterceptor().apply {
                            level = HttpLoggingInterceptor.Level.HEADERS
                        })
                        .build()
                )
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(RedditApi::class.java)
        }

        single<RedditRepository> {
            RedditRepositoryImpl(redditDataSource = get())
        }

        single {
            RedditDataSource(redditApi = get())
        }

        viewModel { RedditListViewModel(redditRepository = get()) }
    }
}
