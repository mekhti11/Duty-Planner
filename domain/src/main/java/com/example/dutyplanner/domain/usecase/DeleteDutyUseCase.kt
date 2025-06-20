package com.example.dutyplanner.domain.usecase

import com.example.dutyplanner.domain.repository.DutyRepository

class DeleteDutyUseCase(private val repo: DutyRepository) {
    suspend operator fun invoke(id: Int) {
        repo.deleteDuty(id)
    }
}