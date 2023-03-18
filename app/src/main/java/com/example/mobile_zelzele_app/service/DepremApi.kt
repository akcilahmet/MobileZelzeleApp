package com.example.mobile_zelzele_app.service

import com.example.mobile_zelzele_app.News
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Url



interface DepremApi {
    //Get

   @GET
   fun getEarthquake(@Url url: String): Single<List<News>>


}

