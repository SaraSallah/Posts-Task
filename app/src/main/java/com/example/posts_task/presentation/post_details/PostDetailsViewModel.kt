package com.example.posts_task.presentation.post_details

import androidx.lifecycle.SavedStateHandle
import com.example.posts_task.data.repository.PostsRepository
import com.example.posts_task.presentation.base.BaseViewModel
import com.example.posts_task.presentation.home.toPostUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject
@HiltViewModel
class PostDetailsViewModel
@Inject constructor(
    private val postsRepository: PostsRepository,
    savedStateHandle: SavedStateHandle,
    ) : BaseViewModel<PostDetailsUiState, Int>(PostDetailsUiState()) {
    override val TAG: String = this::class.java.simpleName
    private val args =PostDetailsFragmentArgs.fromSavedStateHandle(savedStateHandle)

    init {
        getPostDetails()
    }

    fun getPostDetails() {
        _state.update { it.copy(isLoading = true, isError = false) }
        tryToExecute(
            { postsRepository.getPostDetails(args.postId).toPostUiState() } ,
            ::onGetPostDetailsSuccess,
            ::onGetPostDetailsError
        )
    }

    private fun onGetPostDetailsSuccess(post: PostUiState) {
        _state.update { it.copy(isLoading = false, post = post) }
    }

    private fun onGetPostDetailsError(error: String) {
        _state.update { it.copy(isLoading = false, isError = true) }
    }
}