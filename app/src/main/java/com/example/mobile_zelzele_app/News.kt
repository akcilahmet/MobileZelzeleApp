package com.example.mobile_zelzele_app

import com.google.gson.annotations.SerializedName


data class News(
    @SerializedName("Region")
    var cityName: String,
    @SerializedName("ID")
    var districtName :String,
    @SerializedName("Magnitude")
    var magnitude:String,
    @SerializedName("Depth")
    var depth:String,
    @SerializedName("Time")
    var time:String,


    )
