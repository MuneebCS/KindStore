package com.example.kindstore.utils.uiComponents

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import com.example.kindstore.utils.fonts.FontTypes
import com.example.kindstore.utils.theme.getTheme
import com.example.kindstore.utils.theme.primaryColor
import com.example.kindstore.utils.theme.errorColors


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun KTTextField(
    labelValue: String? = null,
    textValue: String,
    onTextValueChanged: (String) -> Unit,
    leadingIcon: Painter? = null,
    trailingIcon: Painter? = null,
    onTrailingIconClick: (() -> Unit)? = null,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    isError: Boolean = false,
    unfocusedColor: Color = primaryColor,
    focusedColor: Color = getTheme().secondary,
    backgroundColor: Color = primaryColor,
    errorColor: Color = errorColors,
    textColor: Color = Color.Black,
    iconTint: Color = getTheme().secondary,
    leadingIconSize: Dp = 20.dp,
    trailingIconSize: Dp = 20.dp,
    cornerRadius: Dp = 10.dp
) {
    OutlinedTextField(
        value = textValue,
        onValueChange = onTextValueChanged,
        label = {
            labelValue?.let {
                Text(
                    text = it,
                    fontSize = 14.sp,
                    fontFamily = FontTypes.robotoFont,
                )
            }
        },
        leadingIcon = leadingIcon?.let {
            {
                Icon(
                    painter = it,
                    contentDescription = null,
                    tint = iconTint,
                    modifier = Modifier.size(leadingIconSize)
                )
            }
        },
        trailingIcon = trailingIcon?.let {
            {
                IconButton(onClick = { onTrailingIconClick?.invoke() }) {
                    Icon(
                        painter = it,
                        contentDescription = null,
                        tint = iconTint,
                        modifier = Modifier.size(trailingIconSize)
                    )
                }
            }
        },
        shape = RoundedCornerShape(cornerRadius),
        singleLine = true,
        isError = isError,
        enabled = enabled,
        colors = OutlinedTextFieldDefaults.colors(
            focusedTextColor = textColor,
            unfocusedTextColor = textColor,
            disabledTextColor = textColor.copy(alpha = 0.5f),
            errorTextColor = errorColor,

            focusedContainerColor = backgroundColor,
            unfocusedContainerColor = backgroundColor,
            disabledContainerColor = backgroundColor,
            errorContainerColor = backgroundColor,

            cursorColor = if (isError) errorColor else focusedColor,

            focusedBorderColor = if (isError) errorColor else focusedColor,
            unfocusedBorderColor = unfocusedColor,
            disabledBorderColor = unfocusedColor.copy(alpha = 0.3f),
            errorBorderColor = errorColor,

            focusedLabelColor = if (isError) errorColor else focusedColor,
            unfocusedLabelColor = unfocusedColor,
            disabledLabelColor = unfocusedColor.copy(alpha = 0.3f),
            errorLabelColor = errorColor,

            focusedLeadingIconColor = if (isError) errorColor else focusedColor,
            unfocusedLeadingIconColor = unfocusedColor,
            errorLeadingIconColor = errorColor,

            focusedTrailingIconColor = if (isError) errorColor else focusedColor,
            unfocusedTrailingIconColor = unfocusedColor,
            errorTrailingIconColor = errorColor
        ),
        modifier = modifier.fillMaxWidth()
    )
}



@Preview(showBackground = true)
@Composable
fun KTTextFieldFullPreview() {
    var text by remember { mutableStateOf("") }
    var isEnabled by remember { mutableStateOf(true) }
    val isError = text.length > 8
        KTTextField(
            labelValue = "Username",
            textValue = text,
            onTextValueChanged = { text = it },
            leadingIcon = painterResource(id = android.R.drawable.ic_menu_myplaces),
            trailingIcon = painterResource(id = android.R.drawable.ic_menu_close_clear_cancel),
            onTrailingIconClick = { text = "" },
            isError = isError,
            enabled = isEnabled,
            unfocusedColor = Color.Gray,
            backgroundColor = Color(0xFFF0F0F0),
            textColor = Color.Black,
            leadingIconSize = 24.dp,
            trailingIconSize = 24.dp,
            cornerRadius = 20.dp
   )
}
