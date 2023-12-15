package com.hridoy.androidblog.view.state

import com.hridoy.androidblog.model.data.api.User

sealed class UserState{
    data object StartState: UserState()
    data object LoadingState: UserState()
    data class Success(val users: List<User>) : UserState()
    data class Error(val errorMessage:String): UserState()
}