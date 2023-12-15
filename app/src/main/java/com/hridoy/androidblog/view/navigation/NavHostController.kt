package com.hridoy.androidblog.view.navigation

import androidx.navigation.NavHostController

fun NavHostController.navigateTo(route: String) = navigate(route) {
    popUpTo(route)
    launchSingleTop = true
}
