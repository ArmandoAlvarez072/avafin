package com.armandoalvarez.avafin

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.armandoalvarez.avafin.data.model.CustomerResponse
import com.armandoalvarez.avafin.ui.components.AutoComplete
import com.armandoalvarez.avafin.ui.components.CustomDialog
import com.armandoalvarez.avafin.ui.components.CustomTextField
import com.armandoalvarez.avafin.ui.components.PrimaryButton
import com.google.gson.internal.LinkedTreeMap

@Composable
fun Form(
    customer: CustomerResponse
) {

    var showDialog by remember { mutableStateOf(false) }
    var isSuccess by remember { mutableStateOf(false) }

    val statusList = remember { mutableStateListOf<Boolean>() }

    CustomDialog(
        showDialog = showDialog,
        title = stringResource(if (isSuccess) R.string.success_text else R.string.alert_text),
        message = stringResource(if (isSuccess) R.string.success_message else R.string.invalid_text),
        onClick = {
            showDialog = false
        }
    )

    customer.data!!.amlCheck?.fieldName = "amlCheck"
    customer.data!!.bankIban?.fieldName = "bankIban"
    customer.data!!.customerBirthday?.fieldName = "customerBirthday"
    customer.data!!.customerFirstname?.fieldName = "customerFirstname"
    customer.data!!.customerGender?.fieldName = "customerGender"
    customer.data!!.customerLastname?.fieldName = "customerLastname"
    customer.data!!.customerMonthlyIncome?.fieldName = "customerMonthlyIncome"
    customer.data!!.customerPersoncode?.fieldName = "customerPersoncode"
    customer.data!!.customerPhone?.fieldName = "customerPhone"
    customer.data!!.language?.fieldName = "language"
    customer.data!!.pepStatus?.fieldName = "pepStatus"
    customer.data!!.customerEmail?.fieldName = "customerEmail"

    var list = listOf(
        customer.data!!.amlCheck,
        customer.data!!.bankIban,
        customer.data!!.customerBirthday,
        customer.data!!.customerFirstname,
        customer.data!!.customerGender,
        customer.data!!.customerLastname,
        customer.data!!.customerMonthlyIncome,
        customer.data!!.customerPersoncode,
        customer.data!!.customerPhone,
        customer.data!!.language,
        customer.data!!.pepStatus,
        customer.data!!.customerEmail,
    )

    list = list.sortedBy { it?.order }
    if (statusList.isEmpty()) {
        repeat(list.size) { statusList.add(false) }
    }

    LazyColumn(Modifier.fillMaxSize()) {

        items(list.size) {

            if (list[it]?.visible == true) {

                if (list[it]?.type == "text") {

                    CustomTextField(
                        Modifier
                            .fillMaxWidth()
                            .padding(
                                start = 24.dp,
                                end = 24.dp,
                                top = 24.dp,
                            )
                            .height(48.dp)
                            .background(
                                color = Color(0xFFEEEEEE),
                                shape = RoundedCornerShape(percent = 30),
                            ),
                        list[it]?.fieldName ?: "",

                        list[it]?.regex,
                        statusList[it]
                    ) { status ->
                        statusList[it] = !status
                    }
                } else if (list[it]?.type == "select") {

                    if (list[it]?.values is ArrayList<*>) {
                        val suggestions = mutableListOf<String>()
                        (list[it]?.values as List<*>).forEach { item ->
                            suggestions.add(item.toString())
                        }

                        AutoComplete(
                            suggestions,
                            Modifier
                                .fillMaxWidth()
                                .padding(
                                    start = 24.dp,
                                    end = 24.dp,
                                    top = 24.dp,
                                )
                                .height(48.dp)
                                .background(
                                    color = Color(0xFFEEEEEE),
                                    shape = RoundedCornerShape(percent = 30),
                                )
                        ) {
                        }

                    } else if (list[it]?.values is LinkedTreeMap<*, *>) {

                        val values =
                            (list[it]?.values as LinkedTreeMap<*, *>)
                                .values
                                .filterIsInstance<String>()
                                .toTypedArray()
                                .toList()

                        AutoComplete(
                            values,
                            Modifier
                                .fillMaxWidth()
                                .padding(
                                    start = 24.dp,
                                    end = 24.dp,
                                    top = 24.dp,
                                )
                                .height(48.dp)
                                .background(
                                    color = Color(0xFFEEEEEE),
                                    shape = RoundedCornerShape(percent = 30),
                                )
                        ) {
                        }
                    }

                }


            } else {
                statusList[it] = true
            }
        }

        item {
            PrimaryButton(
                Modifier
                    .fillMaxWidth()
                    .padding(24.dp),
                stringResource(R.string.validate_text)
            ) {
                showDialog = true
                isSuccess = statusList.all { it }
            }
        }


    }
}