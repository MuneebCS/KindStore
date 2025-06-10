package com.example.kindstore.features.auth.presentation.components



import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kindstore.utils.fonts.FontTypes
import com.example.kindstore.utils.theme.primaryColor
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.example.kindstore.utils.theme.errorColors
import com.example.kindstore.utils.theme.getTheme
import com.example.kindstore.utils.uiComponents.KTTextButton
import com.example.kindstore.utils.uiComponents.KTTextField

@Composable
fun LoginView(
    onRegisterClick: () -> Unit,
    onForgotPasswordClick: () -> Unit,
    onLoginClick: () -> Unit
) {
    val theme = getTheme()
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = theme.secondary)
            .padding(16.dp),
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(20.dp),
            modifier = Modifier.align(Alignment.Center)
        ) {
            Text(
                text = "Login",
                style = TextStyle(
                    fontSize = 26.sp,
                    fontFamily = FontTypes.robotoFont,
                    fontWeight = FontWeight.Bold,
                    color = primaryColor
                ),
                modifier = Modifier.padding(bottom = 16.dp)
            )


            var email by remember { mutableStateOf("") }
            var password by remember { mutableStateOf("") }
            val isEnabled = remember { mutableStateOf(true) }
            val isError = false



            KTTextField(
                labelValue = "Email",
                textValue = email,
                onTextValueChanged = { email = it },
                leadingIcon = painterResource(id = android.R.drawable.ic_menu_myplaces),
                trailingIcon = painterResource(id = android.R.drawable.ic_menu_close_clear_cancel),
                onTrailingIconClick = { email = "" },
                isError = isError,
                enabled = isEnabled.value,
                leadingIconSize = 24.dp,
                trailingIconSize = 24.dp,
            )

            KTTextField(
                labelValue = "Password",
                textValue = password,
                onTextValueChanged = { password = it },
                leadingIcon = painterResource(id = android.R.drawable.ic_menu_myplaces),
                trailingIcon = painterResource(id = android.R.drawable.ic_menu_close_clear_cancel),
                onTrailingIconClick = { password = "" },
                isError = isError,
                enabled = isEnabled.value,
                leadingIconSize = 24.dp,
                trailingIconSize = 24.dp,
            )

            Row() {
                Spacer(modifier = Modifier.weight(1f))
                KTTextButton(
                    text = "Forgot Password?",
                    onTap = onForgotPasswordClick,
                    modifier = Modifier.padding(start = 4.dp),
                    fontSize = 14.sp,
                    fontFamily = FontTypes.robotoFont,
                    fontWeight = FontWeight.SemiBold,
                    letterSpacing = 0.sp,
                    textAllCaps = true,
                    isunderline = true
                )
            }

            KTTextButton(
                text = "Login",
                onTap = onLoginClick,
                modifier = Modifier.fillMaxWidth(),
                height = 60.dp,
                enabled = true,
                elevation = ButtonDefaults.buttonElevation(defaultElevation = 4.dp),
                textColor = Color.White
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    "Don't have an Account?",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontFamily = FontTypes.robotoFont,
                        fontWeight = FontWeight.Bold,
                        color = primaryColor
                    ),
                    modifier = Modifier.padding(end = 4.dp)
                )
                KTTextButton(
                    text = "Register here",
                    onTap = onRegisterClick,
                    modifier = Modifier.padding(start = 4.dp),
                    fontSize = 14.sp,
                    fontFamily = FontTypes.robotoFont,
                    fontWeight = FontWeight.SemiBold,
                    letterSpacing = 0.sp,
                    textAllCaps = true,
                    isunderline = true
                )
            }
        }
    }
}

@Preview(showBackground = true, name = "LoginView Preview")
@Composable
fun PreviewLoginView() {
    LoginView(
        onRegisterClick = {},
        onForgotPasswordClick = {},
        onLoginClick = {}
    )
}
