package com.hridoy.androidblog.view.state

import com.hridoy.androidblog.model.data.api.Post

sealed class PostState{
    data object StartState: PostState()
    data object LoadingState: PostState()
    data class Success(val posts: List<Post>) : PostState()
    data class Error(val errorMessage:String): PostState()
}