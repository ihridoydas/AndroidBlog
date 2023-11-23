package com.hridoy.androidblog.navigation

import androidx.activity.compose.BackHandler
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.hridoy.androidblog.multiLanguage.MultiLanguage
import com.hridoy.androidblog.screens.HomeScreen
import com.hridoy.androidblog.screens.ViewScreen

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun MainAnimationNavHost(
    navController: NavHostController,
    startDestination: String = ScreenDestinations.HomeScreen.route,
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
    ) {
        screen(ScreenDestinations.HomeScreen.route) {
            HomeScreen(navController = navController)
        }
        screen(ScreenDestinations.MultiLanguage.route) {
            MultiLanguage(
                navController = navController,
               onBackPress = {
                    navController.navigateTo(ScreenDestinations.HomeScreen.route)
               }
            )
        }


    }
    //Back Handler
    BackHandler {
        navController.popBackStack()
    }

}