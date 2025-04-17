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
)