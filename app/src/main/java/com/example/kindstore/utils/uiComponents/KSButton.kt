package com.example.kindstore.utils.uiComponents

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kindstore.utils.fonts.FontTypes
import com.example.kindstore.utils.theme.getTheme
import com.example.kindstore.utils.theme.primaryColor


@Composable
fun KTTextButton(
    text: String,
    onTap: () -> Unit,
    modifier: Modifier = Modifier,
    height: Dp = 56.dp,
    width: Dp = Dp.Unspecified,
    backgroundColor: Color = getTheme().secondary,
    contentColor: Color = primaryColor,
    borderColor: Color = primaryColor,
    borderWidth: Dp = 2.dp,
    cornerRadius: Dp = 10.dp,
    textColor: Color = primaryColor,
    enabled: Boolean = true,
    icon: (@Composable (() -> Unit))? = null,
    padding: PaddingValues = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
    elevation: ButtonElevation? = null
) {
    Button(
        onClick = onTap,
        modifier = modifier
            .then(if (width != Dp.Unspecified) Modifier.width(width) else Modifier)
            .height(height),
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor,
            contentColor = contentColor,
            disabledContainerColor = getTheme().secondaryLight,
            disabledContentColor = contentColor.copy(alpha = 0.5f)
        ),
        shape = RoundedCornerShape(cornerRadius),
        enabled = enabled,
        border = BorderStroke(width = borderWidth, color = borderColor),
        contentPadding = padding,
        elevation = elevation
    ) {
        icon?.let {
            it()
            Spacer(modifier = Modifier.width(8.dp))
        }

        Text(
            text = text,
            color = textColor,
            fontSize = 16.sp,
            fontFamily = FontTypes.robotoFont,
            fontWeight = FontWeight.SemiBold
        )
    }
}


@Composable
fun KTIconButton(
    onTap: () -> Unit,
    modifier: Modifier = Modifier,
    icon: @Composable () -> Unit,
    size: Dp = 48.dp,
    backgroundColor: Color = getTheme().secondary,
    contentColor: Color = Color.Black,
    borderColor: Color = Color.Transparent,
    borderWidth: Dp = 1.dp,
    shape: Shape = CircleShape,
    enabled: Boolean = true,
    elevation: ButtonElevation? = null
) {
    Button(
        onClick = onTap,
        modifier = modifier.size(size),
        shape = shape,
        enabled = enabled,
        contentPadding = PaddingValues(0.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor,
            contentColor = contentColor,
            disabledContainerColor = backgroundColor.copy(alpha = 0.3f),
            disabledContentColor = contentColor.copy(alpha = 0.5f)
        ),
        border = BorderStroke(borderWidth, borderColor),
        elevation = elevation
    ) {
        icon()
    }
}

@Composable
fun KTTextButton(
    text: String,
    onTap: () -> Unit,
    modifier: Modifier = Modifier,
    textColor: Color = primaryColor,
    fontSize: TextUnit = 16.sp,
    fontFamily: FontFamily = FontTypes.robotoFont,
    fontWeight: FontWeight = FontWeight.SemiBold,
    letterSpacing: TextUnit = 0.sp,
    textStyle: TextStyle = TextStyle.Default,
    textAllCaps: Boolean = false,
    isunderline: Boolean = false,
) {
    TextButton(
        onClick = onTap,
        modifier = modifier,
        contentPadding = PaddingValues(0.dp) // No extra padding around text
    ) {
        Text(
            text = if (textAllCaps) text.uppercase() else text,
            color = textColor,
            fontSize = fontSize,
            fontFamily = fontFamily,
            fontWeight = fontWeight,
            letterSpacing = letterSpacing,
            style = textStyle,
            textDecoration = if (isunderline) TextDecoration.Underline else TextDecoration.None,
        )
    }
}







@Preview
@Composable
fun ButtonPreviewScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // -- KTTextButton Preview --
        KTTextButton(
            text = "Click Me",
            onTap = { /* Handle tap */ },
            modifier = Modifier.fillMaxWidth(),
            height = 60.dp,
            width = Dp.Unspecified,
            icon = {
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = null,
                )
            },
            padding = PaddingValues(horizontal = 20.dp, vertical = 12.dp),
            elevation = ButtonDefaults.buttonElevation(defaultElevation = 4.dp)
        )

        // -- KTIconButton Preview --
        KTIconButton(
            onTap = { /* Handle tap */ },
            modifier = Modifier,
            icon = {
                Icon(
                    imageVector = Icons.Default.ThumbUp,
                    contentDescription = "Like",
                    tint = Color.White
                )
            },
            size = 56.dp,
            backgroundColor = getTheme().secondary,
            contentColor = Color.White,
            borderColor = Color.Gray,
            borderWidth = 2.dp,
            shape = RoundedCornerShape(12.dp),
            enabled = true,
            elevation = ButtonDefaults.buttonElevation(defaultElevation = 4.dp)
        )
        KTTextButton(
            text = "Click Me",
            onTap = { /* Handle tap */ },
            modifier = Modifier.fillMaxWidth(),
            textColor = Color.White,
            fontSize = 16.sp,
            fontFamily = FontTypes.robotoFont,
            fontWeight = FontWeight.SemiBold,
            letterSpacing = 0.sp,
            textStyle = TextStyle.Default,
            textAllCaps = true
        )

    }
}
