package com.meupacote.newswhitelabel.data

import com.meupacote.newswhitelabel.data.api.NewsApiService
import com.meupacote.newswhitelabel.domain.model.News
import javax.inject.Inject

class NewsRepository @Inject constructor(
    private val newsApiService: NewsApiService
) {
    suspend fun getTopHeadlines(apiKey: String, sources: String): News {
        return newsApiService.getTopHeadlines(apiKey, sources)
    }
}