package com.example.posts_task.domain.usecase

import com.example.posts_task.domain.Post
import com.example.posts_task.domain.repository.PostsRepository
import javax.inject.Inject

class getAllPostsUseCase @Inject constructor(
    private val postsRepository: PostsRepository,
) {
    suspend operator fun invoke(): List<Post> =
        postsRepository.getAllPosts()
}
