package com.meupacote.newswhitelabel.domain.usecase

import com.meupacote.newswhitelabel.domain.model.News

interface GetNewsUseCase {
    suspend operator fun invoke(apiKey: String, sources: String): News
}