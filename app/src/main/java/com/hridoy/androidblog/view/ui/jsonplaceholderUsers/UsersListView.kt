package com.hridoy.androidblog.view.ui.jsonplaceholderUsers

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.hridoy.androidblog.model.data.api.User

@Composable
fun UsersListView(users:List<User>) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        content = {
        items(users){user->
            UserItemView(user = user)
        }
    })
}