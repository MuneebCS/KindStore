package com.example.kindstore.navigation

sealed class Screen(val route : String) {
    object Main: Screen("main_screen")
    object Splash: Screen("splash_screen")
    object OnBoarding: Screen("onboarding_screen")
    object Auth: Screen("auth_screen")
    object Home: Screen("home_screen")
    object CreateDatabase: Screen("create_database_screen")
    object Settings: Screen("settings_screen")
}
