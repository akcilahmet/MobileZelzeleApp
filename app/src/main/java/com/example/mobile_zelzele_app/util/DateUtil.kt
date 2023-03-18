package com.example.mobile_zelzele_app.util

import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit

object DateUtil {

    private val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault())
    private val outputFormat = SimpleDateFormat("dd.MM.yyyy HH:mm", Locale.getDefault())

    private val pattern = "dd.MM.yyyy HH.mm"

    fun formatDateTime(rawDateTime: String): String {
        val date = inputFormat.parse(rawDateTime)
        return outputFormat.format(date!!)
    }


    fun getFormatPassingDateTime(rawDateTime: String): String {
        val inputFormat = SimpleDateFormat("dd.MM.yyyy HH:mm", Locale.getDefault())
        val date = inputFormat.parse(rawDateTime)
        val calendar = Calendar.getInstance().apply {
            date?.let {
                time = it
            }
        }


        val timeDiffMillis = Calendar.getInstance().timeInMillis - (calendar.timeInMillis )
        val daysDiff = TimeUnit.MILLISECONDS.toDays(timeDiffMillis)
        val hoursDiff = TimeUnit.MILLISECONDS.toHours(timeDiffMillis) - daysDiff * 24
        val minutesDiff = TimeUnit.MILLISECONDS.toMinutes(timeDiffMillis) - TimeUnit.HOURS.toMinutes(hoursDiff + daysDiff * 24)

        return when {
            daysDiff > 0 -> "$daysDiff gün önce"
            hoursDiff > 0 -> "$hoursDiff saat $minutesDiff dakika önce"
            else -> "$minutesDiff dakika önce"
        }
    }

}