package com.hridoy.androidblog.navigation

sealed class ScreenDestinations(val route: String) {
     object HomeScreen : ScreenDestinations("home_screen")
     object MultiLanguage : ScreenDestinations("multi_language_screen")
     object ViewScreen : ScreenDestinations("view_screen")
}