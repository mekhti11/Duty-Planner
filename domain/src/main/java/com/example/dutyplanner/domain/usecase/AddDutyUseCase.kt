package com.example.dutyplanner.domain.usecase

import com.example.dutyplanner.domain.model.Duty
import com.example.dutyplanner.domain.repository.DutyRepository


class AddDutyUseCase(private val repo: DutyRepository) {
    suspend operator fun invoke(duty: Duty) = repo.addDuty(duty)
}
