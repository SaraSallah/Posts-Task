package com.example.posts_task.presentation.utils

import android.view.View
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.posts_task.presentation.base.BaseAdapter

@BindingAdapter(value = ["app:items"])
fun <T> setRecyclerItems(view: RecyclerView, items: List<T>?) {
    (view.adapter as BaseAdapter<T>?)?.setItems(items ?: emptyList())
}

@BindingAdapter("app:showIfNotEmpty")
fun <T> showIfNotEmpty(view: View, items: List<T>) {
    view.isVisible = items.isNotEmpty()
}
@BindingAdapter(value = ["app:showWhenError"])
fun showWhenError(view: View, condition: Boolean) {
    view.isVisible = condition
}
@BindingAdapter(value = ["app:showWhenLoading"])
fun showWhenLoading(view: View, state: Boolean) {
    if (state)
        view.visibility = View.VISIBLE
    else
        view.visibility = View.GONE
}

