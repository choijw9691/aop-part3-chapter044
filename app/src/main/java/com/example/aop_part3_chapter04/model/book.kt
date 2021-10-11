package com.example.aop_part3_chapter04.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class book(@SerializedName("title") val title: String,
                @SerializedName("link") val link: String,
                @SerializedName("image") val image: String,
                @SerializedName("author") val author: String,
                @SerializedName("price") val price : Int,
                @SerializedName("discount") val discount : Int,
                @SerializedName("publisher") val publisher : String,
                @SerializedName("pubdate") val pubdate: String,
                @SerializedName("isbn") val isbn: String,
                @SerializedName("description") val description: String
                )
