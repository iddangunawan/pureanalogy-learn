package com.example.pureanalogylearn.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class ApplicationModule {
    @BaseUrl
    @Provides
    fun provideBaseUrlNewsApi(): String = "https://newsapi.org/v2/"

    @NetworkApiKey
    @Provides
    fun provideNewsApiKey(): String = "9f6482a584804376874b848980b7a044" // "b724435f0b354216b8f789bcead2fd66"

    @DatabaseName
    @Provides
    fun provideDatabaseName(): String = "pureanalogy-database"
}