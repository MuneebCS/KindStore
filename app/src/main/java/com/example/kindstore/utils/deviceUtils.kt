package com.example.kindstore.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration

object DeviceUtils {

    @Composable
    fun isTabletLandscape(): Boolean {
        val config = LocalConfiguration.current
        return config.screenWidthDp >= 610 && config.screenWidthDp > config.screenHeightDp
    }

    @Composable
    fun isTabletPortrait(): Boolean {
        val config = LocalConfiguration.current
        return config.screenWidthDp >= 610 && config.screenHeightDp >= config.screenWidthDp
    }

    @Composable
    fun isMobile(): Boolean {
        val config = LocalConfiguration.current
        return config.screenWidthDp < 610
    }
}
