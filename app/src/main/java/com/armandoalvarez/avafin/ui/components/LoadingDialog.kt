package com.armandoalvarez.avafin.ui.components

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.VectorConverter
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.armandoalvarez.avafin.R

@Composable
fun LoadingDialog(
    showDialog: Boolean
) {

    val size = remember { Animatable(100.dp, Dp.VectorConverter) }

    LaunchedEffect(Unit) {
        while (true) {
            size.animateTo(
                targetValue = 120.dp,
                animationSpec = tween(durationMillis = 4000, easing = LinearOutSlowInEasing)
            )
            size.animateTo(
                targetValue = 100.dp,
                animationSpec = tween(durationMillis = 4000, easing = LinearOutSlowInEasing)
            )
        }
    }

    if (showDialog) {
        Dialog(onDismissRequest = {}) {

            Box(
                modifier = Modifier
                    .size(size.value)
                    .background(Color.Transparent),
                contentAlignment = Alignment.Center
            ) {

                Image(
                    painter = painterResource(id = R.drawable.avafin),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(CircleShape)
                        .background(Color.Transparent)
                )

                CircularProgressIndicator(
                    modifier = Modifier
                        .fillMaxSize(),
                    color = MaterialTheme.colorScheme.secondary,
                    strokeWidth = 4.dp,
                )
            }
        }
    }

}