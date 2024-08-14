package com.armandoalvarez.avafin.ui.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import com.armandoalvarez.avafin.R
import com.armandoalvarez.avafin.ui.theme.colorPrimaryDark

@Composable
fun PrimaryButton(
    modifier: Modifier,
    text: String,
    onClick: () -> Unit
) {
    Button(
        onClick = { onClick() },
        modifier = modifier,
        shape = RoundedCornerShape(percent = 30),
        colors = ButtonDefaults.buttonColors(
            containerColor = colorPrimaryDark
        ),
    ) {
        Text(
            text = text,
            fontFamily = FontFamily(
                Font(R.font.rubik_semibold)
            ),
            fontSize = 16.sp,
            lineHeight = 18.sp
        )
    }
}