package com.armandoalvarez.avafin.ui.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.armandoalvarez.avafin.R
import com.armandoalvarez.avafin.ui.theme.darkFontColor
import com.armandoalvarez.avafin.ui.theme.fontColor

@Composable
fun TextTitle(
    modifier: Modifier,
    text: String,
    textAlign: TextAlign,
) {
    Text(
        text = text,
        color = darkFontColor,
        fontFamily = FontFamily(
            Font(R.font.rubik)
        ),
        fontSize = 18.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.2.sp,
        modifier = modifier,
        textAlign = textAlign
    )
}