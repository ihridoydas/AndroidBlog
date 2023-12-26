package com.hridoy.androidblog.view.navigation

import androidx.activity.compose.BackHandler
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.hridoy.androidblog.view.ui.multiLanguage.MultiLanguage
import com.hridoy.androidblog.view.ui.screens.ScratchCardScreen
import com.hridoy.androidblog.view.ui.screens.HomeScreen
import com.hridoy.androidblog.view.ui.screens.MVVMStateManagementScreenPosts
import com.hridoy.androidblog.view.ui.screens.MVVMStateManagementScreenUsers

@OptIn(ExperimentalAnimationApi::class, ExperimentalComposeUiApi::class)
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
        screen(ScreenDestinations.MVVMStateUser.route) {
            MVVMStateManagementScreenUsers(navController = navController,
                onBackPress = {
                    navController.navigateTo(ScreenDestinations.HomeScreen.route)
                }
            )
        }
        screen(ScreenDestinations.MVVMStatePost.route) {
            MVVMStateManagementScreenPosts(navController = navController,
                onBackPress = {
                    navController.navigateTo(ScreenDestinations.HomeScreen.route)
                }
            )
        }
        screen(ScreenDestinations.ScratchCard.route) {
            ScratchCardScreen(onBackPress = {
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