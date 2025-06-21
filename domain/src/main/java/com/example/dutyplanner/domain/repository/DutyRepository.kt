package com.example.dutyplanner.domain.repository


import com.example.dutyplanner.domain.model.DateRange
import com.example.dutyplanner.domain.model.Duty
import com.example.dutyplanner.domain.model.DutyFilter
import com.example.dutyplanner.domain.model.DutySortBy
import com.example.dutyplanner.domain.model.DutyType
import kotlinx.coroutines.flow.Flow
import kotlinx.datetime.LocalDate


interface DutyRepository {

    // Basic CRUD operations
    suspend fun addDuty(duty: Duty): Result<Unit>
    suspend fun updateDuty(duty: Duty): Result<Unit>
    suspend fun deleteDuty(dutyId: String): Result<Unit>
    suspend fun getDutyById(id: String): Result<Duty?>

    // Query operations
    fun getDutiesForDate(date: LocalDate): Flow<List<Duty>>
    fun getDutiesInDateRange(startDate: LocalDate, endDate: LocalDate): Flow<List<Duty>>
    fun getAllDuties(): Flow<List<Duty>>

    // Search and filter
    fun searchDuties(query: String): Flow<List<Duty>>
    fun getDutiesWithFilter(filter: DutyFilter, sortBy: DutySortBy): Flow<List<Duty>>

    // Statistics
    suspend fun getDutyCount(): Int
    suspend fun getDutyCountByType(type: DutyType): Int
    suspend fun getCompletionRate(dateRange: DateRange?): Float

    // Batch operations
    suspend fun deleteDuties(dutyIds: List<String>): Result<Unit>
    suspend fun markDutiesAsCompleted(dutyIds: List<String>): Result<Unit>
}
