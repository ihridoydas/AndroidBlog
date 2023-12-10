package com.hridoy.androidblog.view.ui.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.hridoy.androidblog.view.ui.jsonplaceholderPosts.PostListView
import com.hridoy.androidblog.view.ui.jsonplaceholderUsers.UsersListView
import com.hridoy.androidblog.viewmodel.JsonPlaceHolderPostsViewModel
import com.hridoy.androidblog.viewmodel.JsonPlaceHolderUsersViewModel
import com.hridoy.androidblog.view.state.PostState
import com.hridoy.androidblog.view.state.UserState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MVVMStateManagementScreenPosts(
    postsViewModel: JsonPlaceHolderPostsViewModel = hiltViewModel(),
    navController: NavController,
    onBackPress : ()->Unit,
) {
    val context = LocalContext.current
    val postState by postsViewModel.postState.collectAsState()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "MVVM State Management Posts",
                        fontSize = 14.sp,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Left
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            onBackPress()
                        },
                        modifier = Modifier
                    ) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
                    }
                },

            )
        }
    ) {
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(it)){
            when(postState){
                is PostState.LoadingState->{
                    Box(modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center){
                        CircularProgressIndicator()
                    }
                }
                is PostState.StartState->{}
                is PostState.Success->{
                    val posts = (postState as PostState.Success).posts
                    PostListView(posts)
                }
                is PostState.Error->{
                    val message = (postState as PostState.Error).errorMessage
                    Toast.makeText(context,message,Toast.LENGTH_LONG).show()
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 6.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = message,
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black,
                        )
                    }
                }
            }
        }

    }
}
