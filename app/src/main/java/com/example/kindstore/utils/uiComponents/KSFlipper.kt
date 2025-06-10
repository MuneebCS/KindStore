package com.example.kindstore.utils.uiComponents

import android.R
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.kindstore.features.auth.presentation.view.AuthScreen
import com.example.kindstore.utils.theme.primaryColor
import kotlin.math.cos


@Composable
fun KSFlipper(
    currentState: AuthScreen,
    views: Map<AuthScreen, @Composable () -> Unit>,
    viewHeights: Map<AuthScreen, Dp>
) {
    val rotation = remember { Animatable(0f) }
    var previousState by remember { mutableStateOf(currentState) }

    // Calculate target rotation
    LaunchedEffect(currentState) {
        if (previousState != currentState) {
            previousState = currentState
            rotation.animateTo(
                targetValue = rotation.value + 180f,
                animationSpec = tween(durationMillis = 500, easing = LinearOutSlowInEasing)
            )
        }
    }

    val cardHeight by animateDpAsState(
        targetValue = viewHeights[currentState] ?: 0.dp,
        animationSpec = tween(durationMillis = 1000, easing = LinearOutSlowInEasing)
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .height(cardHeight)
            .graphicsLayer {
                rotationY = rotation.value
                cameraDistance = 12 * density
            }
            .background(Color.Black, shape = RoundedCornerShape(20.dp)) // Rounded corners added here
            .shadow(8.dp, shape = RoundedCornerShape(20.dp)) // Optional shadow for a floating effect
        ,
        contentAlignment = Alignment.Center
    ) {
        val isFront = rotation.value % 360 < 90f || rotation.value % 360 > 270f
        if (isFront) {
            views[currentState]?.invoke()
        } else {
            Box(modifier = Modifier.graphicsLayer { rotationY = 180f }) {
                views[previousState]?.invoke()
            }
        }
    }
}

