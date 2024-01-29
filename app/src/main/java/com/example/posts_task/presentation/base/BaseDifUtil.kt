package com.example.posts_task.presentation.base

import androidx.recyclerview.widget.DiffUtil

class BaseDifUtil<T>(
    private val oldList: List<T>,
    private val newList: List<T>,
    private val checkIsSameItem: (oldList: T, newList: T) -> Boolean,
    private val checkIsSameContent: (oldList: T, newList: T) -> Boolean,
) : DiffUtil.Callback() {
    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return checkIsSameItem(oldList[oldItemPosition], newList[newItemPosition])
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return checkIsSameContent(oldList[oldItemPosition], newList[newItemPosition])
    }

}