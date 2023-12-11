package com.hridoy.androidblog.navigation

import androidx.navigation.NavHostController

/**
 * Ajhbjh
 * jbnkj
 * jbhjhbkj
 * jkn kj
 *
 */
fun NavHostController.navigateTo(route: String) = navigate(route) {
    popUpTo(route)
    launchSingleTop = true
}
