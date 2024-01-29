package com.example.posts_task.data.repository

import com.example.posts_task.data.api.PostsServices
import com.example.posts_task.data.remote.model.Post
import com.example.posts_task.data.remote.model.Posts
import retrofit2.Response
import javax.inject.Inject

class PostsRepository @Inject constructor(
    private val api: PostsServices,
) {
    suspend fun getAllPosts(): Posts = wrap { api.getAllPosts() }

    suspend fun getPostDetails(postId: Int): Post =wrap { api.getPostDetails(postId) }


    private suspend fun <T : Any> wrap(function: suspend () -> Response<T>): T {
        val response = function()
        return if (response.isSuccessful)
            response.body() ?: throw Throwable("Response body is null")
        else
            throw Throwable("Request failed with status code ${response.code()}")

    }
}