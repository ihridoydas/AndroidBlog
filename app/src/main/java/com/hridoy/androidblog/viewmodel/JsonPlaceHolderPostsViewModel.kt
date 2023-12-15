package com.hridoy.androidblog.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hridoy.androidblog.model.data.api.User
import com.hridoy.androidblog.model.interfaces.services.UserServices
import com.hridoy.androidblog.view.state.PostState
import com.hridoy.androidblog.view.state.UserState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class JsonPlaceHolderPostsViewModel @Inject constructor(
    private val postServices: UserServices,

) : ViewModel(){

    val postState = MutableStateFlow<PostState>(PostState.StartState)

    init {
        fetchPosts()
    }

    private fun fetchPosts(){
        viewModelScope.launch {
            postState.tryEmit(PostState.LoadingState)

            try {
                val posts = postServices.fetchUserPosts()
                postState.tryEmit(PostState.Success(posts))
            }
            catch (e:Exception){
                e.localizedMessage?.let { PostState.Error(errorMessage = it) }
                    ?.let { postState.tryEmit(it) }
            }
        }
    }

}