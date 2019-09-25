package com.strajnsak.mastrnews

import java.text.SimpleDateFormat
import java.util.*

fun covertMilisecondsToDateTimeRepresentation(miliseconds: Long): String{
    val calendar = Calendar.getInstance()
    calendar.timeInMillis = miliseconds
    val dateFormat = SimpleDateFormat.getDateInstance()
    return dateFormat.format(calendar.time)
}