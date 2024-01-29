package com.example.posts_task.presentation.home

import androidx.lifecycle.viewModelScope
import com.example.posts_task.data.repository.PostsRepository
import com.example.posts_task.presentation.base.BaseViewModel
import com.example.posts_task.presentation.post_details.PostUiState
import com.example.posts_task.presentation.utils.EventHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val postsRepository: PostsRepository,
) : BaseViewModel<HomeUiState, Int>(HomeUiState()),PostInterActionListener {
    override val TAG: String = this::class.java.simpleName

    init {
        getAllPosts()
    }

    fun getAllPosts() {
        _state.update { it.copy(isLoading = true, isError = false) }
        tryToExecute(
            { postsRepository.getAllPosts().map { it.toPostUiState() } },
            ::onGetAllPostsSuccess,
            ::onGetAllPostsError
        )
    }

    private fun onGetAllPostsSuccess(posts: List<PostUiState>) {
        _state.update { it.copy(isLoading = false, posts = posts) }
    }

    private fun onGetAllPostsError(error: String) {
        _state.update { it.copy(isLoading = false, isError = true) }
    }

    override fun onClickPost(postID: Int) {
        viewModelScope.launch {
            _effect.emit(EventHandler(postID))
        }
    }
}