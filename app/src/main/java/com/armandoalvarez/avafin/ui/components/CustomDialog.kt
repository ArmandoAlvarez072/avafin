package com.armandoalvarez.avafin.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.armandoalvarez.avafin.R

@Composable
fun CustomDialog(
    showDialog: Boolean,
    title: String,
    message: String,
    onClick: () -> Unit
) {

    if (showDialog) {
        Dialog(onDismissRequest = onClick) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .background(Color.White),
            ) {
                TextTitle(
                    Modifier
                        .fillMaxWidth()
                        .padding(
                            top = 24.dp,
                            start = 24.dp,
                            end = 24.dp,
                        ),
                    title,
                    TextAlign.Center
                )

                TextBody(
                    Modifier
                        .fillMaxWidth()
                        .padding(
                            top = 24.dp,
                            start = 24.dp,
                            end = 24.dp,
                        ),
                    message,
                    TextAlign.Center
                )

                PrimaryButton(
                    Modifier
                        .fillMaxWidth()
                        .padding(24.dp),
                    stringResource(R.string.close_text),
                    onClick
                )
            }


        }
    }

}