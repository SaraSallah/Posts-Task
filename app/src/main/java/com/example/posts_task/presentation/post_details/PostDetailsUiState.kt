package com.example.posts_task.presentation.post_details

data class PostDetailsUiState(
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val post: PostUiState = PostUiState(),
)

data class PostUiState(
    val id: Int? = 0,
    val userId: Int? = 0,
    val title: String? = "",
    val body: String? = "",

    )