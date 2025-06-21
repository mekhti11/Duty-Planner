package com.example.dutyplanner.domain.usecase

import com.example.dutyplanner.domain.model.Duty
import com.example.dutyplanner.domain.repository.DutyRepository
import javax.inject.Inject

class UpdateDutyUseCase @Inject constructor(
    private val repository: DutyRepository,
    private val validateDuty: ValidateDutyUseCase
) {
    suspend operator fun invoke(duty: Duty): Result<Unit> {
        val validationResult = validateDuty(duty)
        if (validationResult.isFailure) {
            return validationResult
        }
        
        val updatedDuty = duty.copy(
            updatedAt = kotlinx.datetime.Clock.System.now()
        )
        
        return repository.updateDuty(updatedDuty)
    }
}