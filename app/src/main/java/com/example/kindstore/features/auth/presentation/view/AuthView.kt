package com.example.kindstore.features.auth.presentation.view

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.kindstore.features.auth.presentation.components.*
import com.example.kindstore.navigation.Screen
import com.example.kindstore.utils.fonts.FontTypes
import com.example.kindstore.utils.theme.getTheme
import com.example.kindstore.utils.theme.primaryColor
import com.example.kindstore.utils.uiComponents.KSFlipper

@Composable
fun AuthView(navController: NavController) {
    val theme = getTheme()
    var currentScreen by remember { mutableStateOf<AuthScreen>(AuthScreen.Login) }

    BackHandler(enabled = currentScreen != AuthScreen.Login) {
        currentScreen = AuthScreen.Login
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(theme.secondary)
            .padding(20.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Header()

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(560.dp),
                shape = RoundedCornerShape(30.dp),
                colors = CardDefaults.cardColors(containerColor = primaryColor),
                elevation = CardDefaults.cardElevation(10.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(primaryColor, shape = RoundedCornerShape(30.dp))
                        .padding(10.dp),
                    contentAlignment = Alignment.Center
                ) {
                    KSFlipper(
                        currentState = currentScreen,
                        views = mapOf(
                            AuthScreen.Login to {
                                LoginView(
                                    onRegisterClick = { currentScreen = AuthScreen.Register },
                                    onForgotPasswordClick = { currentScreen = AuthScreen.ForgotPassword },
                                    onLoginClick = {
                                        navController.navigate(Screen.Main.route) {
                                            popUpTo(Screen.Auth.route) { inclusive = true }
                                        }
                                    }
                                )
                            },
                            AuthScreen.Register to {
                                RegisterView(
                                    onLoginClick = { currentScreen = AuthScreen.Login },
                                    onVerifyClick = { currentScreen = AuthScreen.VerifyEmail }
                                )
                            },
                            AuthScreen.VerifyEmail to {
                                VerifyEmailView(
                                    onBackToLogin = { currentScreen = AuthScreen.Login }
                                )
                            },
                            AuthScreen.ForgotPassword to {
                                ForgotPasswordView(
                                    onBackToLogin = { currentScreen = AuthScreen.Login }
                                )
                            }
                        ),
                        viewHeights = mapOf(
                            AuthScreen.Login to 350.dp,
                            AuthScreen.Register to 350.dp,
                            AuthScreen.VerifyEmail to 350.dp,
                            AuthScreen.ForgotPassword to 350.dp
                        )
                    )
                }
            }

            Footer()
        }
    }
}

@Composable
fun Header() {
    Text(
        text = "Welcome to KindStore",
        fontSize = 30.sp,
        fontWeight = FontWeight.Bold,
        color = primaryColor,
        fontFamily = FontTypes.robotoFont,
        modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
    )
}

@Composable
fun Footer() {
    Text(
        text = "Powered by MMI",
        fontSize = 14.sp,
        fontWeight = FontWeight.Bold,
        color = primaryColor,
        fontFamily = FontTypes.robotoFont,
        modifier = Modifier.padding(bottom = 12.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun AuthViewPreview() {
    AuthView(navController = rememberNavController())
}
