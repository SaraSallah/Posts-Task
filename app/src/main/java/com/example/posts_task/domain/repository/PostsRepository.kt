package com.example.posts_task.domain.repository

import com.example.posts_task.domain.Post


interface PostsRepository {
    suspend fun getAllPosts(): List<Post>

    suspend fun getPostDetails(postId: Int): Post
}