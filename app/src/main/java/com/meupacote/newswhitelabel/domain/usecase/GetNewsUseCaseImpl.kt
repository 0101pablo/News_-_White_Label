package com.meupacote.newswhitelabel.domain.usecase

import com.meupacote.newswhitelabel.data.NewsRepository
import com.meupacote.newswhitelabel.domain.model.News
import javax.inject.Inject

class GetNewsUseCaseImpl @Inject constructor(
    private val newsRepository: NewsRepository
) : GetNewsUseCase {
    override suspend fun invoke(apiKey: String, sources: String): News {
        return newsRepository.getTopHeadlines(apiKey, sources)
    }
}