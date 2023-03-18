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






   @GET
   fun getDeprem(@Url url: String): Single<List<News>>


}

