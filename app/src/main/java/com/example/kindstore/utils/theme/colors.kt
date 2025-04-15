package com.example.kindstore.utils.theme

import androidx.compose.ui.graphics.Color


val primary = Color(0xFFBBBDBC)
//val secondary = Color(0xFF245F73) by defualt

interface ThemeColors {
    val secondary:Color
    val secondaryLight: Color
}


class DynamicTheme(private val colorHex: String) : ThemeColors {
    override val secondary = Color(android.graphics.Color.parseColor("#$colorHex"))
    override val secondaryLight: Color = generateSecondaryLight(secondary)

   private fun generateSecondaryLight(color: Color) : Color {
        return secondary.copy(alpha = 0.4f)
    }
}






