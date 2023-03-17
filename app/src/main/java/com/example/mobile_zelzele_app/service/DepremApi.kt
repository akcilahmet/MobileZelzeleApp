package com.example.mobile_zelzele_app.service

import com.example.mobile_zelzele_app.News
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import java.net.URLEncoder
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*


interface DepremApi {
    //Get

    //https://api.orhanaydogdu.com.tr/deprem/kandilli/live
    //BASE_URL ->https://api.orhanaydogdu.com.tr/
    //deprem/kandilli/live
    //https://github.com/atilsamancioglu/BTK20-JSONVeriSeti/blob/master/besinler.json




    @GET("apiv2/event/filter?start=2020-09-14%2010:00:00&end=2021-09-16%2010:00:00&limit=50")
    fun getDeprem():Single<List<News>>


}

class Test{
    fun main() {
        // Şu anki tarihi ve saati alın
        val now = Date()

        // API çağrısı için formatlanmış tarih ve saat değeri oluşturun
        val endDateTime = now.toString()

        // end parametresini güncel tarih ve saate ayarlayın
        val apiUrl = "https://deprem.afad.gov.tr/apiv2/event/filter?start=2020-09-14 10:00:00&end=$endDateTime"

        // URL'yi kodlayın
        val encodedUrl = URLEncoder.encode(apiUrl, "UTF-8")

        // Sonuçları yazdırın
        println(encodedUrl)
    }
}