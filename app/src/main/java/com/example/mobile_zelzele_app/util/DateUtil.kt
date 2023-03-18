package com.example.mobile_zelzele_app.util

import java.text.SimpleDateFormat
import java.util.*

object DateUtil {

    private val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault())
    private val outputFormat = SimpleDateFormat("dd.MM.yyyy HH:mm", Locale.getDefault())

    fun formatDateTime(rawDateTime: String): String {
        val date = inputFormat.parse(rawDateTime)
        return outputFormat.format(date!!)
    }
}