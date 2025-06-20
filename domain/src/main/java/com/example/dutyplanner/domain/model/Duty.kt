package com.example.dutyplanner.domain.model

import kotlinx.datetime.LocalDate

data class Duty(
    val id: Int = 0,
    val title: String,
    val date: LocalDate,
    val type: DutyType
)
