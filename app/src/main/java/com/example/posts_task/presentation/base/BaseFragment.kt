package com.example.posts_task.presentation.base

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.example.posts_task.BR

abstract class BaseFragment<VB : ViewDataBinding> : Fragment() {
    abstract val TAG: String
    abstract val layoutIdFragment: Int
    abstract val viewModel: ViewModel
    private lateinit var _binding: VB
    protected val binding get() = _binding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = DataBindingUtil.inflate(inflater, layoutIdFragment, container, false)
        _binding.apply {
            lifecycleOwner = viewLifecycleOwner
            setVariable(BR.viewModel, viewModel)
            return root
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUp()
    }

    protected open fun setUp() {
    }

    protected fun log(message: Any) {
        Log.e(TAG, message.toString())
    }
}