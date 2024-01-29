package com.example.posts_task.data.repository

import com.example.posts_task.data.api.PostsServices
import com.example.posts_task.data.remote.mapper.toPost
import com.example.posts_task.domain.model.Post
import retrofit2.Response
import javax.inject.Inject

class PostsRepository @Inject constructor(
    private val api: PostsServices,
) {
     suspend fun getAllPosts(): List<Post> = wrap { api.getAllPosts() }.map { it.toPost() }

     suspend fun getPostDetails(postId: Int): Post =wrap { api.getPostDetails(postId)}.toPost()


    private suspend fun <T : Any> wrap(function: suspend () -> Response<T>): T {
        val response = function()
        return if (response.isSuccessful)
            response.body() ?: throw Throwable("Response body is null")
        else
            throw Throwable("Request failed with status code ${response.code()}")

    }
}