package com.example.posts_task.ui.utils

open class EventHandler<out T>(private val content: T) {
    private var hasBeenHandled = false

    fun getContentIfHandled(): T? {
        return if (hasBeenHandled)
            null
        else {
            hasBeenHandled = true
            content
        }
    }
}