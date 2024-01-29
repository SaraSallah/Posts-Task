package com.example.posts_task.presentation.home

import androidx.fragment.app.viewModels
import com.example.posts_task.R
import com.example.posts_task.databinding.FragmentHomeBinding
import com.example.posts_task.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment :BaseFragment<FragmentHomeBinding>(){
    override val TAG: String = this::class.java.simpleName
    override val layoutIdFragment: Int =R.layout.fragment_home
    override val viewModel:HomeViewModel by viewModels()
    private val postsAdapter by lazy { {PostsAdapter(viewModel)} }

    override fun setUp() {
        initAdapter()
    }

    private fun initAdapter() {

    }
}