package com.example.dutyplanner.domain.repository

import com.example.dutyplanner.domain.model.Duty
import kotlinx.coroutines.flow.Flow
import kotlinx.datetime.LocalDate

interface DutyRepository {
    suspend fun addDuty(duty: Duty)
    fun getDutiesForDate(date: LocalDate): Flow<List<Duty>>
    fun getDutiesForRange(start: LocalDate, end: LocalDate): Flow<List<Duty>>
    suspend fun deleteDuty(id: Int)
}
