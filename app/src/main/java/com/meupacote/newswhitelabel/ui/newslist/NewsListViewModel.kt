package com.meupacote.newswhitelabel.ui.newslist

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.meupacote.newswhitelabel.domain.model.News
import com.meupacote.newswhitelabel.domain.usecase.GetNewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsListViewModel @Inject constructor(
    private val getNewsUseCase: GetNewsUseCase
) : ViewModel() {

    private val apiKey = "052837010a39425091c0f185fa4ffdb4"
    private val source = "bbc-news"

    private val _newsData = MutableLiveData<News>()
    val newsData: LiveData<News> = _newsData

    fun getNews() = viewModelScope.launch {
        try {
            val news = getNewsUseCase(apiKey, source)
            _newsData.value = news
        } catch (e: Exception) {
            Log.d("NewsListViewModel", e.toString())
            _newsData.value = News()
        }
    }
}