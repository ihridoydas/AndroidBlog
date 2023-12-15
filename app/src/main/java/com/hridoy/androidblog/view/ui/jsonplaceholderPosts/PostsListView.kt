package com.hridoy.androidblog.view.ui.jsonplaceholderPosts

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.hridoy.androidblog.model.data.api.Post

@Composable
fun PostListView(posts:List<Post>) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        content = {
        items(posts){post->
            PostItemView(post = post)
        }
    })
}