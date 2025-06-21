package com.example.dutyplanner.domain.usecase

import com.example.dutyplanner.domain.model.Duty
import com.example.dutyplanner.domain.repository.DutyRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.datetime.LocalDate
import javax.inject.Inject

class GetDutiesForDateUseCase @Inject constructor(
    private val repository: DutyRepository
) {
    operator fun invoke(date: LocalDate): Flow<List<Duty>> {
        return repository.getDutiesForDate(date)
            .map { duties ->
                duties.sortedWith(
                    compareBy<Duty> { it.startTime ?: "00:00" }
                        .thenByDescending { it.priority.level }
                        .thenBy { it.title }
                )
            }
    }
}