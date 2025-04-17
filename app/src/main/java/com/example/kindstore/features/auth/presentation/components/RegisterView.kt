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
fun RegisterView(
    onLoginClick: () -> Unit,
    onVerifyClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = primaryColor) // Apply background color to the entire box
            .padding(16.dp),
        contentAlignment = Alignment.Center // Center the content inside the box
    ) {
    Column(
        modifier = Modifier.padding(16.dp).background(color = primaryColor),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(text = "Register View")

        Button(onClick = onLoginClick) {
            Text("Back to Login")
        }

        Button(onClick = onVerifyClick) {
            Text("Verify Email")
        }
    }
}
}
