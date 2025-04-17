package com.example.kindstore.features.auth.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kindstore.utils.theme.primaryColor


@Composable
fun ForgotPasswordView(
    onBackToLogin: () -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = primaryColor) // Apply background color to the entire box
            .padding(16.dp),
        contentAlignment = Alignment.Center // Center the content inside the box
    ) {
        Column(
          // Center column content horizontally
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp) // Adjust the spacing between elements
        ) {
            Text(
                text = "Forgot Password", // Title text
                fontSize = 24.sp, // Larger font size for visibility
                color = Color.White // White text color for contrast
            )

            // Add more UI elements here (like a text field for email)

            Button(
                onClick = onBackToLogin,
                modifier = Modifier.fillMaxWidth() // Make the button full width
            ) {
                Text(
                    text = "Back to Login",
                    fontSize = 16.sp,
                    color = Color.White
                )
            }
        }
    }
}
