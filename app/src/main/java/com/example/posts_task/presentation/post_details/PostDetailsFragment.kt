package com.example.posts_task.presentation.post_details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import com.example.posts_task.R
import com.example.posts_task.databinding.FragmentPostDetailsBinding
import com.example.posts_task.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PostDetailsFragment :BaseFragment<FragmentPostDetailsBinding>(){
    override val TAG: String =this::class.java.simpleName
    override val layoutIdFragment: Int =R.layout.fragment_post_details
    override val viewModel:PostDetailsViewModel by viewModels()

}