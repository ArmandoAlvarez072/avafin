package com.armandoalvarez.avafin.ui.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.armandoalvarez.avafin.R
import com.armandoalvarez.avafin.ui.theme.fontColor

@Composable
fun TextBody(
    modifier: Modifier,
    text: String,
    textAlign: TextAlign,
) {
    Text(
        text = text,
        color = fontColor,
        fontFamily = FontFamily(
            Font(R.font.rubik)
        ),
        fontSize = 14.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.2.sp,
        modifier = modifier,
        textAlign = textAlign
    )
}