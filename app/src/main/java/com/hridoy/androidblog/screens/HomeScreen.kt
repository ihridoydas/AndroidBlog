package com.hridoy.androidblog.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import com.hridoy.androidblog.navigation.ScreenDestinations

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
                    navController?.navigate(ScreenDestinations.MultiLanguage.route) {
                        popUpTo(ScreenDestinations.HomeScreen.route) {
                            inclusive = false
                        }
                    }
                }) {
                Text(modifier = Modifier, textAlign = TextAlign.Center,
                    text = "複数言語をサポート画面へ\nナビゲーション")
            }
        }

    }

}