package com.example.aop_part3_chapter04.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName


data class SearchBooksDto(
    @SerializedName("lastBuildDate") val lastBuildDate: String,
    @SerializedName("total") val total: Int,
    @SerializedName("start") val start: Int,
    @SerializedName("display") val display: Int,
    @SerializedName("items") val items : List<book>
)

