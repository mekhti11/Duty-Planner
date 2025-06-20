package com.example.dutyplanner.domain.usecase
import com.example.dutyplanner.domain.model.Duty
import com.example.dutyplanner.domain.repository.DutyRepository

import kotlinx.coroutines.flow.Flow
import kotlinx.datetime.LocalDate

class GetDutiesForDateUseCase(private val repo: DutyRepository) {
    operator fun invoke(date: LocalDate): Flow<List<Duty>> = repo.getDutiesForDate(date)
}