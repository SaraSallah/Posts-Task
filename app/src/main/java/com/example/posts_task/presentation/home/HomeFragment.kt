package com.example.posts_task.presentation.home

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.collect
import com.example.posts_task.R
import com.example.posts_task.databinding.FragmentHomeBinding
import com.example.posts_task.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment :BaseFragment<FragmentHomeBinding>(){
    override val TAG: String = this::class.java.simpleName
    override val layoutIdFragment: Int =R.layout.fragment_home
    override val viewModel:HomeViewModel by viewModels()
    private val postsAdapter:PostsAdapter by lazy {PostsAdapter(viewModel)}

    override fun setUp() {
        initAdapter()
        collectAction()
    }

    private fun initAdapter() {
        binding.rvPosts.adapter = postsAdapter

    }
    private fun collectAction() {
        collect(viewModel.effect) { effect ->
            effect.getContentIfHandled()?.let { onEffect(it) }
        }
    }

    private fun onEffect(postId: Int) {
        navigateToBookDetails(postId)
    }

    private fun navigateToBookDetails(postId: Int) {
        val action = HomeFragmentDirections.actionHomeFragmentToPostDetailsFragment(postId)
        findNavController().navigate(action)
    }
}