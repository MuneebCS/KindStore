package com.example.kindstore.utils.fonts

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import com.example.kindstore.R

object FontTypes {
    val robotoFont = FontFamily(Font(R.font.roboto_light))
}

val appTypography = Typography(
    displayLarge = TextStyle(fontFamily = FontTypes.robotoFont),
    displayMedium = TextStyle(fontFamily = FontTypes.robotoFont),
    displaySmall = TextStyle(fontFamily = FontTypes.robotoFont),
    headlineLarge = TextStyle(fontFamily = FontTypes.robotoFont),
    headlineMedium = TextStyle(fontFamily = FontTypes.robotoFont),
    headlineSmall = TextStyle(fontFamily = FontTypes.robotoFont),
    titleLarge = TextStyle(fontFamily = FontTypes.robotoFont),
    titleMedium = TextStyle(fontFamily = FontTypes.robotoFont),
    titleSmall = TextStyle(fontFamily = FontTypes.robotoFont),
    bodyLarge = TextStyle(fontFamily = FontTypes.robotoFont),
    bodyMedium = TextStyle(fontFamily = FontTypes.robotoFont),
    bodySmall = TextStyle(fontFamily = FontTypes.robotoFont),
    labelLarge = TextStyle(fontFamily = FontTypes.robotoFont),
    labelMedium = TextStyle(fontFamily = FontTypes.robotoFont),
    labelSmall = TextStyle(fontFamily = FontTypes.robotoFont)
)