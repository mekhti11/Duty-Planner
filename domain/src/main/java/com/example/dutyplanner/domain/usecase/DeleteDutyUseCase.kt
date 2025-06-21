package com.example.dutyplanner.domain.usecase

import com.example.dutyplanner.domain.repository.DutyRepository
import javax.inject.Inject

class DeleteDutyUseCase @Inject constructor(
    private val repository: DutyRepository
) {
    suspend operator fun invoke(dutyId: String): Result<Unit> {
        require(dutyId.isNotBlank()) { "Duty ID cannot be blank" }
        return repository.deleteDuty(dutyId)
    }
}