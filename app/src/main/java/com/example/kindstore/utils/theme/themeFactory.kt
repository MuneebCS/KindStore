package com.example.kindstore.utils.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.example.kindstore.utils.fonts.appTypography


object ThemeFactory {
    fun getTheme(colorHex: String): ThemeColors {
        return DynamicTheme(colorHex)
    }
}


// State holder for the current theme
object ThemeState {
    var currentTheme by mutableStateOf("245F73")
}


// Update the current theme
fun updateTheme(colorHex: String) {
    println("Updating theme to color: #$colorHex")
    ThemeState.currentTheme = colorHex
}


val LocalTheme = compositionLocalOf { ThemeFactory.getTheme(ThemeState.currentTheme) }


@Composable
fun ThemeProvider(content: @Composable () -> Unit) {
    val theme = remember(ThemeState.currentTheme) { ThemeFactory.getTheme(ThemeState.currentTheme) }
    CompositionLocalProvider(LocalTheme provides theme) {
        MaterialTheme(
            typography = appTypography,
        ) {
            content()
        }
    }
}

@Composable
fun getTheme(): ThemeColors {
    return LocalTheme.current
}
