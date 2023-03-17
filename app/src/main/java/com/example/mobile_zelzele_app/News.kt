package com.example.mobile_zelzele_app

import com.google.gson.annotations.SerializedName


data class News(
    @SerializedName("province")
    var cityName: String,
    @SerializedName("district")
    var districtName :String,
    @SerializedName("magnitude")
    var magnitude:Double,
    @SerializedName("depth")
    var depth:Double,
    @SerializedName("date")
    var time:String,


    )
