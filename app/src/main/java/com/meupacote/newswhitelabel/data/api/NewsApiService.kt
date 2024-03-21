package com.meupacote.newswhitelabel.data.api

import com.meupacote.newswhitelabel.domain.model.News
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {

    @GET("top-headlines")
    suspend fun getTopHeadlines(
        @Query("apiKey") apiKey: String, @Query("sources") sources: String
    ): News
}