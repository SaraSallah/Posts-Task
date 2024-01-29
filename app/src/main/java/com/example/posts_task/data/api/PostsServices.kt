package com.example.posts_task.data.api

import com.example.posts_task.data.remote.model.Post
import com.example.posts_task.data.remote.model.Posts
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PostsServices {
    @GET("/posts")
    suspend fun getAllPosts():Response<Posts>

    @GET("/posts/id")
    suspend fun getPostDetails(@Path("id") id :Int):Response<Post>

}