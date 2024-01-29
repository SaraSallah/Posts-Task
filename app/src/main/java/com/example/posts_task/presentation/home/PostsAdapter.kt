package com.example.posts_task.presentation.home

import com.example.posts_task.R
import com.example.posts_task.presentation.base.BaseAdapter
import com.example.posts_task.presentation.base.BaseInteractionListener
import com.example.posts_task.presentation.post_details.PostUiState

class PostsAdapter (listener: PostInterActionListener):BaseAdapter<PostUiState>(listener){
    override val layoutId: Int = R.layout.item_post

}
interface PostInterActionListener:BaseInteractionListener{

    fun onClickPost(postID : Int)
}