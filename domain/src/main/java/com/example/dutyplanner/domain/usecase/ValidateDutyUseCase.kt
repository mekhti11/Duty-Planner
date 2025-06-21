package com.example.dutyplanner.domain.usecase

import com.example.dutyplanner.domain.model.Duty
import javax.inject.Inject

class ValidateDutyUseCase @Inject constructor() {
    
    operator fun invoke(duty: Duty): Result<Unit> {
        return when {
            duty.title.isBlank() -> Result.failure(
                IllegalArgumentException("Title cannot be blank")
            )
            
            duty.title.length > MAX_TITLE_LENGTH -> Result.failure(
                IllegalArgumentException("Title cannot exceed $MAX_TITLE_LENGTH characters")
            )
            
            duty.description?.length ?: 0 > MAX_DESCRIPTION_LENGTH -> Result.failure(
                IllegalArgumentException("Description cannot exceed $MAX_DESCRIPTION_LENGTH characters")
            )
            
            !isValidTimeRange(duty.startTime, duty.endTime) -> Result.failure(
                IllegalArgumentException("Start time must be before end time")
            )
            
            else -> Result.success(Unit)
        }
    }
    
    private fun isValidTimeRange(startTime: String?, endTime: String?): Boolean {
        if (startTime == null || endTime == null) return true
        
        return try {
            val start = timeStringToMinutes(startTime)
            val end = timeStringToMinutes(endTime)
            start < end
        } catch (e: Exception) {
            false
        }
    }
    
    private fun timeStringToMinutes(time: String): Int {
        val parts = time.split(":")
        if (parts.size != 2) throw IllegalArgumentException("Invalid time format")
        
        val hours = parts[0].toInt()
        val minutes = parts[1].toInt()
        
        if (hours !in 0..23 || minutes !in 0..59) {
            throw IllegalArgumentException("Invalid time values")
        }
        
        return hours * 60 + minutes
    }
    
    companion object {
        const val MAX_TITLE_LENGTH = 100
        const val MAX_DESCRIPTION_LENGTH = 500
    }
}