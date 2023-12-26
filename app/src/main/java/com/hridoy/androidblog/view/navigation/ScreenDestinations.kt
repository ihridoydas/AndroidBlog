package com.hridoy.androidblog.view.navigation

sealed class ScreenDestinations(val route: String) {
     data object HomeScreen : ScreenDestinations("home_screen")
     data object MultiLanguage : ScreenDestinations("multi_language_screen")
     data object ViewScreen : ScreenDestinations("view_screen")
     data object MVVMStateUser : ScreenDestinations("mvvm_state_management_user")
     data object MVVMStatePost : ScreenDestinations("mvvm_state_management_post")
     data object ScratchCard : ScreenDestinations("scratch_card_screen")
}