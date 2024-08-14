package com.armandoalvarez.avafin.data.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class CustomerResponse(
    @SerializedName("data")
    var data: Data?,
    @SerializedName("ok")
    var ok: Int?
) : Parcelable