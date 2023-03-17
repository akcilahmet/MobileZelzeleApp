package com.example.mobile_zelzele_app.service

import com.example.mobile_zelzele_app.News
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET

interface DepremApi {
    //Get

    //https://api.orhanaydogdu.com.tr/deprem/kandilli/live
    //BASE_URL ->https://api.orhanaydogdu.com.tr/
    //deprem/kandilli/live
    //https://github.com/atilsamancioglu/BTK20-JSONVeriSeti/blob/master/besinler.json

    @get:GET("apiv2/event/filter")
    val posts:Observable<List<News>>
}