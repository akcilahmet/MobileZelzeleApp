package com.example.mobile_zelzele_app.service

import com.example.mobile_zelzele_app.News
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object DepremAPIService {
    private var ourinstance:Retrofit?=null

    val instance:Retrofit
        get() {
            if(ourinstance==null){
                ourinstance=Retrofit.Builder()
                    .baseUrl("https://deprem.afad.gov.tr/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                    .build()

            }
            return ourinstance!!
        }



}