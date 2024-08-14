package com.armandoalvarez.avafin.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.armandoalvarez.avafin.R
import com.armandoalvarez.avafin.ui.theme.errorColor
import com.armandoalvarez.avafin.ui.theme.fontColor
import com.armandoalvarez.avafin.ui.theme.fontLightColor

@Composable
fun CustomTextField(
    modifier: Modifier,
    placeholder: String,
    regexStr: String?,
    isError: Boolean,
    onValueChanged: (Boolean) -> Unit
) {

    var value by remember { mutableStateOf("") }
    var error by remember { mutableStateOf(!isError) }

    OutlinedTextField(
        modifier = modifier,
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedBorderColor = Color.Transparent,
            focusedBorderColor = Color.Transparent,
            disabledBorderColor = Color.Transparent,
            errorBorderColor = Color.Transparent
        ),
        singleLine = true,
        isError = error,
        value = value,
        onValueChange = { newText ->

            value = newText

            if (regexStr != null) {
                val regex = regexStr.toRegex()
                error = !regex.matches(newText)
            }

            onValueChanged(error)

        },

        placeholder = {
            Text(
                text = placeholder,
                color = fontLightColor,
                fontFamily = FontFamily(
                    Font(R.font.rubik)
                ),
                fontSize = 14.sp,
                lineHeight = 16.sp,
                letterSpacing = 0.2.sp,
            )
        },

        textStyle = TextStyle(
            color = fontColor,
            fontFamily = FontFamily(
                Font(R.font.rubik)
            ),
            fontSize = 14.sp,
            lineHeight = 16.sp,
            letterSpacing = 0.2.sp
        )

    )

    if (error) {

        Text(
            text = stringResource(R.string.field_error),
            color = errorColor,
            fontFamily = FontFamily(
                Font(R.font.rubik)
            ),
            fontSize = 12.sp,
            lineHeight = 14.sp,
            letterSpacing = 0.2.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 24.dp,
                    end = 24.dp,
                    top = 8.dp
                )
        )

    }
}