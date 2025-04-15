package com.example.kindstore

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.kindstore.features.auth.presentation.view.AuthView
import com.example.kindstore.features.home.presentation.view.HomeView
import com.example.kindstore.features.onboarding.OnBoardingView
import com.example.kindstore.features.splash.SplashView
import com.example.kindstore.utils.constants.Routes
import com.example.kindstore.utils.theme.ThemeProvider

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            ThemeProvider {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = Routes.splash,
                        modifier = Modifier
                            .consumeWindowInsets(innerPadding)
                            .padding(innerPadding)
                    ) {
                        composable(Routes.splash) {
                            SplashView(navController)
                        }
                        composable(Routes.onboarding) {
                            OnBoardingView(navController)
                        }
                        composable(Routes.auth) {
                            AuthView(navController)
                        }
                        composable(Routes.home) {
                            HomeView(navController)
                        }
                    }
                }
            }
        }
    }
}
