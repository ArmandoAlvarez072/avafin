package com.armandoalvarez.avafin.data.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Data(
    @SerializedName("aml-check")
    var amlCheck: CustomerData?,
    @SerializedName("bank-iban")
    var bankIban: CustomerData?,
    @SerializedName("customer-birthday")
    var customerBirthday: CustomerData?,
    @SerializedName("customer-email")
    var customerEmail: CustomerData?,
    @SerializedName("customer-firstname")
    var customerFirstname: CustomerData?,
    @SerializedName("customer-gender")
    var customerGender: CustomerData?,
    @SerializedName("customer-lastname")
    var customerLastname: CustomerData?,
    @SerializedName("customer-monthly-income")
    var customerMonthlyIncome: CustomerData?,
    @SerializedName("customer-personcode")
    var customerPersoncode: CustomerData?,
    @SerializedName("customer-phone")
    var customerPhone: CustomerData?,
    @SerializedName("language")
    var language: CustomerData?,
    @SerializedName("pep-status")
    var pepStatus: CustomerData?
): Parcelable