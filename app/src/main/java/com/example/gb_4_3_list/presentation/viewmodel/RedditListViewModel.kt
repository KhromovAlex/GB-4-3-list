package com.example.gb_4_3_list.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.gb_4_3_list.domain.entity.Post
import com.example.gb_4_3_list.domain.repository.RedditRepository
import io.reactivex.rxjava3.disposables.CompositeDisposable
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class RedditListViewModel(
    private val redditRepository: RedditRepository,
) : ViewModel() {
    private val disposables = CompositeDisposable()
    private val _liveData = MutableLiveData<PagingData<Post>>()
    val liveData: LiveData<PagingData<Post>> = _liveData

    init {
        viewModelScope.launch {
            redditRepository.getPosts()
                .cachedIn(viewModelScope)
                .collectLatest {
                    _liveData.postValue(it)
                }
        }
    }

    override fun onCleared() {
        super.onCleared()
        disposables.clear()
    }

}
