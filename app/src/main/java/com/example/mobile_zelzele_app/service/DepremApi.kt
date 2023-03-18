package com.example.mobile_zelzele_app.service

import com.example.mobile_zelzele_app.News
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Url
import java.net.URLEncoder
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*


interface DepremApi {
    //Get





   /* @GET("apiv2/event/filter?start=2020-09-14%2010:00:00&end=2021-09-16%2010:00:00&limit=50")
    fun getDeprem():Single<List<News>>*/
   @GET
   fun getDeprem(@Url url: String): Single<List<News>>


}

