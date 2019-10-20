package br.com.mirabilis.jambu_air.model

import com.google.gson.annotations.SerializedName

data class mTOP (
    val header : String,
    @SerializedName("sub") val sub : mSubTOP
)

data class mSubTOP(
    val warna : String,
    val jenis : String
)