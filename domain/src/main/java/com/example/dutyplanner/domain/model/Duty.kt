package com.example.dutyplanner.domain.model

import kotlinx.datetime.LocalDate

data class Duty(
    val id: String,
    val title: String,
    val type: DutyType,
    val date: LocalDate,
    val startTime: String? = null,
    val endTime: String? = null,
    val description: String? = null,
    val isCompleted: Boolean = false,
    val priority: Priority = Priority.MEDIUM,
    val createdAt: kotlinx.datetime.Instant = kotlinx.datetime.Clock.System.now(),
    val updatedAt: kotlinx.datetime.Instant = kotlinx.datetime.Clock.System.now()
)