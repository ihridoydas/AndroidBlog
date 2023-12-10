package com.hridoy.androidblog.view.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.hridoy.androidblog.view.navigation.ScreenDestinations

@Composable
fun HomeScreen(
    navController: NavController,
) {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxSize(),
            Arrangement.Center,
            Alignment.CenterHorizontally
        ) {
            Button(
                modifier = Modifier
                    .size(300.dp, 60.dp),
                onClick = {
                    navController?.navigate(ScreenDestinations.MVVMStateUser.route) {
                        popUpTo(ScreenDestinations.HomeScreen.route) {
                            inclusive = false
                        }
                    }
                }) {
                Text(modifier = Modifier, textAlign = TextAlign.Center,
                    text = "MVVM State Management Users")
            }

            Spacer(modifier = Modifier.size(10.dp))

            Button(
                modifier = Modifier
                    .size(300.dp, 60.dp),
                onClick = {
                    navController?.navigate(ScreenDestinations.MVVMStatePost.route) {
                        popUpTo(ScreenDestinations.HomeScreen.route) {
                            inclusive = false
                        }
                    }
                }) {
                Text(modifier = Modifier, textAlign = TextAlign.Center,
                    text = "MVVM State Management Posts")
            }
        }

    }

}