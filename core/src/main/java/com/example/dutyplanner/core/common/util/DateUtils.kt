package com.example.dutyplanner.core.common.util

import kotlinx.datetime.*


object DateUtils {

    /**
     * Get current date using system timezone
     * @return LocalDate representing today
     */
    fun getCurrentDate(): LocalDate {
        return Clock.System.now()
            .toLocalDateTime(TimeZone.currentSystemDefault())
            .date
    }

    /**
     * Format date for display (e.g., "Saturday, June 21, 2025")
     * @param date LocalDate to format
     * @return Formatted date string
     */
    fun formatDateForDisplay(date: LocalDate): String {
        val dayNames = listOf(
            "Monday", "Tuesday", "Wednesday", "Thursday",
            "Friday", "Saturday", "Sunday"
        )
        val monthNames = listOf(
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
        )

        val dayOfWeek = dayNames[date.dayOfWeek.ordinal]
        val monthName = monthNames[date.monthNumber - 1]

        return "$dayOfWeek, $monthName ${date.dayOfMonth}, ${date.year}"
    }

    /**
     * Format date for short display (e.g., "Jun 21")
     * @param date LocalDate to format
     * @return Short formatted date string
     */
    fun formatDateShort(date: LocalDate): String {
        val monthAbbrev = listOf(
            "Jan", "Feb", "Mar", "Apr", "May", "Jun",
            "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"
        )

        return "${monthAbbrev[date.monthNumber - 1]} ${date.dayOfMonth}"
    }

    /**
     * Check if date is today
     * @param date LocalDate to check
     * @return true if date is today
     */
    fun isToday(date: LocalDate): Boolean {
        return date == getCurrentDate()
    }

    /**
     * Check if date is tomorrow
     * @param date LocalDate to check
     * @return true if date is tomorrow
     */
    fun isTomorrow(date: LocalDate): Boolean {
        val tomorrow = getCurrentDate().plus(1, DateTimeUnit.DAY)
        return date == tomorrow
    }

    /**
     * Check if date is yesterday
     * @param date LocalDate to check
     * @return true if date is yesterday
     */
    fun isYesterday(date: LocalDate): Boolean {
        val yesterday = getCurrentDate().minus(1, DateTimeUnit.DAY)
        return date == yesterday
    }

    /**
     * Get relative date string (Today, Tomorrow, Yesterday, or formatted date)
     * @param date LocalDate to format
     * @return Relative date string
     */
    fun getRelativeDateString(date: LocalDate): String {
        return when {
            isToday(date) -> "Today"
            isTomorrow(date) -> "Tomorrow"
            isYesterday(date) -> "Yesterday"
            else -> formatDateShort(date)
        }
    }

    /**
     * Add days to date
     * @param date Base date
     * @param days Number of days to add
     * @return New LocalDate
     */
    fun addDays(date: LocalDate, days: Int): LocalDate {
        return date.plus(days, DateTimeUnit.DAY)
    }

    /**
     * Subtract days from date
     * @param date Base date
     * @param days Number of days to subtract
     * @return New LocalDate
     */
    fun subtractDays(date: LocalDate, days: Int): LocalDate {
        return date.minus(days, DateTimeUnit.DAY)
    }

    /**
     * Get days between two dates
     * @param startDate Start date
     * @param endDate End date
     * @return Number of days between dates
     */
    fun daysBetween(startDate: LocalDate, endDate: LocalDate): Int {
        return startDate.daysUntil(endDate)
    }
}