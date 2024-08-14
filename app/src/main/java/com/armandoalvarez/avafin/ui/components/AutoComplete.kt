package com.armandoalvarez.avafin.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
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
import androidx.compose.ui.unit.sp
import com.armandoalvarez.avafin.R
import com.armandoalvarez.avafin.ui.theme.fontColor
import com.armandoalvarez.avafin.ui.theme.fontLightColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AutoComplete(
    suggestions: List<String>,
    modifier: Modifier,
    onValueChanged: (String?) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    var selectedText by remember { mutableStateOf("") }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = {
            expanded = !expanded
        },
        modifier = modifier
    ) {
        OutlinedTextField(
            value = selectedText,
            onValueChange = { newText ->
                selectedText = newText
                expanded = true
            },
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = Color.Transparent,
                focusedBorderColor = Color.Transparent,
                disabledBorderColor = Color.Transparent,
                errorBorderColor = Color.Transparent
            ),
            modifier = Modifier
                .fillMaxWidth()
                .menuAnchor(),
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
            },
            singleLine = true,
            enabled = false,
            textStyle = TextStyle(
                color = fontColor,
                fontFamily = FontFamily(
                    Font(R.font.rubik)
                ),
                fontSize = 14.sp,
                lineHeight = 16.sp,
                letterSpacing = 0.2.sp
            ),
            placeholder = {
                Text(
                    text = stringResource(R.string.autocomplete_hint),
                    color = fontLightColor,
                    fontFamily = FontFamily(
                        Font(R.font.rubik)
                    ),
                    fontSize = 14.sp,
                    lineHeight = 16.sp,
                    letterSpacing = 0.2.sp,
                )
            },
        )

        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = {
                expanded = false
            },
            modifier = Modifier.background(Color.White)
        ) {
            suggestions.forEach { suggestion ->
                DropdownMenuItem(
                    modifier = Modifier.background(Color.White),
                    text = {
                        Text(
                            color = fontColor,
                            fontFamily = FontFamily(
                                Font(R.font.rubik)
                            ),
                            fontSize = 14.sp,
                            lineHeight = 16.sp,
                            letterSpacing = 0.2.sp,
                            text = suggestion.toString()
                        )
                    },
                    onClick = {
                        selectedText = suggestion
                        onValueChanged(selectedText)
                        expanded = false
                    }
                )
            }
        }
    }

}