package com.hridoy.androidblog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.hridoy.androidblog.navigation.MainAnimationNavHost
import com.hridoy.androidblog.ui.theme.AndroidBlogTheme
import dagger.hilt.android.AndroidEntryPoint

/**
 * Ajhbjh
 * jbnkj
 * jbhjhbkj
 * jkn kj
 *
 */
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            AndroidBlogTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainAnimationNavHost(
                        navController = navController
                    )

                }
            }
        }
    }
}
