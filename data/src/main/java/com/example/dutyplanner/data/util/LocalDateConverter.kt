package com.example.dutyplanner.data.util

import androidx.room.TypeConverter
import kotlinx.datetime.LocalDate
import kotlinx.datetime.toLocalDate

object LocalDateConverter {
    @TypeConverter
    fun fromString(value: String): LocalDate = value.toLocalDate()

    @TypeConverter
    fun toString(date: LocalDate): String = date.toString()
}