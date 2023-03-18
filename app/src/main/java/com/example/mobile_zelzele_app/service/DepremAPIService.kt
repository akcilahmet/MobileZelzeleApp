package com.example.mobile_zelzele_app.service

import com.example.mobile_zelzele_app.News
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import io.reactivex.rxjava3.core.Single
import org.joda.time.DateTime
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.URI
import java.net.URL
import java.text.SimpleDateFormat
import java.util.*

object DepremAPIService {

    private var ourinstance: DepremApi? = null

    fun getInstance(): DepremApi {
        if (ourinstance == null) {
            ourinstance = Retrofit.Builder()
                .baseUrl("https://deprem.afad.gov.tr/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build()
                .create(DepremApi::class.java)
        }
        return ourinstance!!
    }

    fun getDeprem(): Single<List<News>> {
        val url = deneme()
        return getInstance().getDeprem(url)
    }

    fun deneme(vararg strings: String): String{
        val currentDate = Date()
        val dateFormat = SimpleDateFormat("yyyy-MM-dd")
        val dateString = dateFormat.format(currentDate)


        val baseUrl = "https://deprem.afad.gov.tr/"
        val path = "apiv2/event/filter"
        val queryParams = listOf("start" to "2021-09-14%2010:00:00", "end" to dateString+"%2010:00:00", "limit" to "20")

        val url = buildString {
            append(baseUrl)
            append(path)
            append("?")
            append(queryParams.joinToString("&") { "${it.first}=${it.second}" })
        }

        val uri = URI(url)
        val pathWithQueryParams = "${uri.path}?${uri.query}" // bu değer depremapiye atanacak
        println("cıktıııııı "+pathWithQueryParams)
        return pathWithQueryParams+"&orderby=timedesc"+"&minmag=2.5"

    }




}