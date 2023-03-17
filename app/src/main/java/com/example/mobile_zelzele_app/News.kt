package com.example.mobile_zelzele_app

import com.google.gson.annotations.SerializedName


data class News(
    @SerializedName("start")
    var cityName: String,
    @SerializedName("end")
    var districtName :String,
    @SerializedName("orderby")
    var magnitude:String,
    @SerializedName("minmag")
    var depth:String,
    @SerializedName("limit")
    var time:String,


    )
