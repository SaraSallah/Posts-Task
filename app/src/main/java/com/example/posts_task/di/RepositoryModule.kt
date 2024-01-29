package com.example.posts_task.di

import com.example.posts_task.data.api.PostsServices
import com.example.posts_task.data.repository.PostsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Singleton
    @Provides
    fun providePostsRepository(api: PostsServices): PostsRepository = PostsRepository(api)
}