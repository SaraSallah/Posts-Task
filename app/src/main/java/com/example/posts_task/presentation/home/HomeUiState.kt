package com.example.posts_task.presentation.home

import com.example.posts_task.data.remote.model.Post
import com.example.posts_task.presentation.post_details.PostUiState

data class HomeUiState(
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val posts: List<PostUiState> = emptyList(),
)

fun Post.toPostUiState(): PostUiState = PostUiState(
    id = id,
    userId = userId,
    title = title,
    body = body
)