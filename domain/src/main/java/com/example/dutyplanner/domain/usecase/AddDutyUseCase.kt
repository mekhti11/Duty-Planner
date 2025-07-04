package com.example.dutyplanner.domain.usecase

import com.example.dutyplanner.domain.model.Duty
import com.example.dutyplanner.domain.repository.DutyRepository
import javax.inject.Inject

class AddDutyUseCase @Inject constructor(
    private val repository: DutyRepository,
    private val validateDuty: ValidateDutyUseCase
) {
    suspend operator fun invoke(duty: Duty): Result<Unit> {
        val validationResult = validateDuty(duty)
        if (validationResult.isFailure) {
            return validationResult
        }

        return try {
            repository.addDuty(duty)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}