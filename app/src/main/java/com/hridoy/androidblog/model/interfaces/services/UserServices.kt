package com.hridoy.androidblog.model.interfaces.services

import com.hridoy.androidblog.model.data.api.Post
import com.hridoy.androidblog.model.data.api.User
import retrofit2.http.GET

interface UserServices {
    @GET(value = "/users")
    suspend fun fetchUser() : List<User>

    @GET(value = "/users/1/posts")
    suspend fun fetchUserPosts() : List<Post>

}