package com.hridoy.androidblog.navigation

import androidx.activity.compose.BackHandler
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.hridoy.androidblog.lazyColumnScrollbar.LazyColumnView
import com.hridoy.androidblog.multiLanguage.MultiLanguage

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
            LazyColumnView()
//             lazyGridView()
//            ColumnView()
          //  HomeScreen(navController = navController)
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