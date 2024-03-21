package com.meupacote.newswhitelabel.domain.usecase.di

import com.meupacote.newswhitelabel.domain.usecase.GetNewsUseCase
import com.meupacote.newswhitelabel.domain.usecase.GetNewsUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface DomainModule {
    @Binds
    fun bindGetNewsUseCase(useCase: GetNewsUseCaseImpl): GetNewsUseCase
}