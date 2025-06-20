package com.example.dutyplanner.domain.usecase


import com.example.dutyplanner.domain.model.Duty
import com.example.dutyplanner.domain.repository.DutyRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.datetime.LocalDate

class GetDutiesForRangeUseCase(private val repo: DutyRepository) {
    operator fun invoke(start: LocalDate, end: LocalDate): Flow<List<Duty>> {
        return repo.getDutiesForRange(start, end)
    }
}
