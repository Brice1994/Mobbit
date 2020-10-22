package com.example.mobbit.commons.extensions

import java.text.SimpleDateFormat
import java.util.*


fun Long.getFormattedDate(): String {
    val pattern = "yyyy-MM-dd"
    val simpleDateFormat = SimpleDateFormat(pattern, Locale.getDefault())
    return simpleDateFormat.format(Date())
}