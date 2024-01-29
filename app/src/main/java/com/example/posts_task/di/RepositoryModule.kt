package com.example.posts_task.di

import com.example.posts_task.data.api.PostsServices
import com.example.posts_task.data.repository.PostsRepositoryImp
import com.example.posts_task.domain.repository.PostsRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindPostsRepository(repository: PostsRepositoryImp): PostsRepository
}
