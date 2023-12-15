package com.hridoy.androidblog.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hridoy.androidblog.model.data.api.User
import com.hridoy.androidblog.model.interfaces.services.UserServices
import com.hridoy.androidblog.view.state.UserState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class JsonPlaceHolderUsersViewModel @Inject constructor(
    private val userServices: UserServices,

) : ViewModel(){

    val userState = MutableStateFlow<UserState>(UserState.StartState)

    init {
        fetchUsers()
    }

    private fun fetchUsers(){
        viewModelScope.launch {
            userState.tryEmit(UserState.LoadingState)

            try {
                val users = userServices.fetchUser()
                userState.tryEmit(UserState.Success(users))
            }
            catch (e:Exception){
                e.localizedMessage?.let { UserState.Error(errorMessage = it) }
                    ?.let { userState.tryEmit(it) }
            }
        }
    }

}