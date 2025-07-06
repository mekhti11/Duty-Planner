package com.example.dutyplanner.domain.usecase

import com.example.dutyplanner.domain.model.Duty
import com.example.dutyplanner.domain.model.DutyType
import com.example.dutyplanner.domain.model.Priority
import kotlinx.coroutines.test.runTest
import kotlinx.datetime.LocalDate
import org.junit.Assert.assertTrue
import org.junit.Test

class ValidateDutyUseCaseTest {

    private val validateDuty = ValidateDutyUseCase()

    private fun createDuty(start: String?, end: String?): Duty {
        return Duty(
            id = "1",
            title = "Title",
            type = DutyType.SHIFT,
            date = LocalDate(2023, 1, 1),
            startTime = start,
            endTime = end,
            description = "desc",
            priority = Priority.MEDIUM
        )
    }

    @Test
    fun `valid time range passes validation`() = runTest {
        val duty = createDuty("08:00", "09:00")
        val result = validateDuty(duty)
        assertTrue(result.isSuccess)
    }

    @Test
    fun `invalid range returns failure`() = runTest {
        val duty = createDuty("10:00", "09:00")
        val result = validateDuty(duty)
        assertTrue(result.isFailure)
    }

    @Test
    fun `malformed time strings return failure`() = runTest {
        val duty = createDuty("08", "09:00")
        val result = validateDuty(duty)
        assertTrue(result.isFailure)
    }
}
