package com.example.kindstore.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.createGraph
import com.example.kindstore.features.CreateDB.presentation.CreateDBView
import com.example.kindstore.features.Settings.Presentation.SettingsView
import com.example.kindstore.features.home.presentation.view.HomeView

@Composable
fun MainScreen() {
    val bottomNavController = rememberNavController()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = { BottomNavigationBar(bottomNavController) }
    ) { innerPadding ->
        NavHost(
            navController = bottomNavController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.Home.route) {
                HomeView()
            }
            composable(Screen.CreateDatabase.route) {
                CreateDBView()
            }
            composable(Screen.Settings.route) {
                SettingsView()
            }
        }
    }
}

