package com.example.dutyplanner.domain.model

import kotlinx.datetime.LocalDate


data class DutyFilter(
    val types: Set<DutyType> = emptySet(),
    val priorities: Set<Priority> = emptySet(),
    val isCompleted: Boolean? = null,
    val dateRange: DateRange? = null,
    val searchQuery: String? = null
)

/**
 * Date range for filtering
 */
data class DateRange(
    val startDate: LocalDate,
    val endDate: LocalDate
) {
    init {
        require(startDate <= endDate) { "Start date must be before or equal to end date" }
    }
}

/**
 * Sort options for duties
 */
enum class DutySortBy {
    DATE_ASC,
    DATE_DESC,
    TITLE_ASC,
    TITLE_DESC,
    PRIORITY_ASC,
    PRIORITY_DESC,
    CREATED_AT_ASC,
    CREATED_AT_DESC
}