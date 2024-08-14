package com.armandoalvarez.avafin.data.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class CustomerData(
    @SerializedName("maxlength")
    var maxlength: Int,
    @SerializedName("order")
    var order: Int?,
    @SerializedName("regex")
    var regex: String?,
    @SerializedName("type")
    var type: String?,
    @SerializedName("values")
    var values: @RawValue Any?,
    @SerializedName("visible")
    var visible: Boolean?,
    var fieldName: String?
) : Parcelable