package com.example.posts_task.domain.usecase

import com.example.posts_task.data.repository.PostsRepository
import com.example.posts_task.domain.model.Post
import javax.inject.Inject

class GetAllPostsUseCase @Inject constructor(
    private val postsRepository: PostsRepository,
) {
    suspend operator fun invoke(): List<Post> =
        postsRepository.getAllPosts()
}
