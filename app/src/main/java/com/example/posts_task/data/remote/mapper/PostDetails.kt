package com.example.posts_task.data.remote.mapper

import com.example.posts_task.data.remote.model.Post


fun Post.toPost() = com.example.posts_task.domain.model.Post(
    id = id ?: 0,
    userId = userId ?: 0,
    title = title ?: "",
    body = body ?: ""

)