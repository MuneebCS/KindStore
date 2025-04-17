package com.example.kindstore.features.auth.presentation.view

sealed class AuthScreen {
    object Login : AuthScreen()
    object Register : AuthScreen()
    object ForgotPassword : AuthScreen()
    object VerifyEmail : AuthScreen()
}
