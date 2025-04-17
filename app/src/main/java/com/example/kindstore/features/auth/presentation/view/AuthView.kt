package com.example.kindstore.features.auth.presentation.view

import androidx.compose.foundation.background
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.example.kindstore.features.auth.presentation.components.ForgotPasswordView
import com.example.kindstore.features.auth.presentation.components.LoginView
import com.example.kindstore.features.auth.presentation.components.RegisterView
import com.example.kindstore.features.auth.presentation.components.VerifyEmailView
import com.example.kindstore.utils.fonts.FontTypes
import com.example.kindstore.utils.theme.getTheme
import com.example.kindstore.utils.theme.primaryColor
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.Dp
import com.example.kindstore.utils.uiComponents.KSFlipper


@Composable
fun AuthView(navController: NavController) {
    val theme = getTheme()
    var currentScreen by remember { mutableStateOf<AuthScreen>(AuthScreen.Login) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(theme.secondary)
    ) {
        Header()

        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {
            KSFlipper(
                currentState = currentScreen,
                views = mapOf(
                    AuthScreen.Login to {
                        LoginView(
                            onRegisterClick = { currentScreen = AuthScreen.Register },
                            onForgotPasswordClick = { currentScreen = AuthScreen.ForgotPassword }
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

        Footer()
    }
}



@Composable
fun Header() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .height(50.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Welcome to KindStore",
            fontSize = 24.sp,
            color = primaryColor,
            fontWeight = FontWeight.SemiBold,
            fontFamily = FontTypes.robotoFont
        )
    }
}


@Composable
fun Footer() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
            .height(50.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "MMI",
            fontSize = 15.sp,
            color = primaryColor,
            fontWeight = FontWeight.Bold,
            fontFamily = FontTypes.robotoFont
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AuthViewPreview() {
    AuthView(navController = NavController(context = LocalContext.current))
}
