package com.example.posts_task.presentation.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.posts_task.BR

interface BaseInteractionListener
abstract class BaseAdapter<T>(
    private val listener: BaseInteractionListener,
) : RecyclerView.Adapter<BaseAdapter.BaseViewHolder>() {

    private var items = emptyList<T>()
    abstract val layoutId: Int
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ItemViewHolder(DataBindingUtil.inflate(inflater, layoutId, parent, false))
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        if (holder is ItemViewHolder) bind(holder, position)
    }

    open fun bind(holder: ItemViewHolder, position: Int) {
        holder.binding.apply {
            setVariable(BR.item, items[position])
            setVariable(BR.listener, listener)
        }
    }

    override fun getItemCount(): Int = items.size

    open fun setItems(newItems: List<T>) {
        val diffResult =
            DiffUtil.calculateDiff(BaseDifUtil(items, newItems, ::areItemSame, ::areContentSame))
        items = newItems
        diffResult.dispatchUpdatesTo(this)

    }

    open fun areItemSame(oldItem: T, newItem: T): Boolean {
        return oldItem?.equals(newItem) == true
    }

    open fun areContentSame(oldPosition: T, newPosition: T) = true

    class ItemViewHolder(val binding: ViewDataBinding) : BaseViewHolder(binding)
    abstract class BaseViewHolder(binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root)
}