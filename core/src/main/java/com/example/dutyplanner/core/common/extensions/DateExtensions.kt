package com.example.dutyplanner.core.common.extensions

import com.example.dutyplanner.core.common.util.DateUtils
import kotlinx.datetime.LocalDate

/**
 * Extension functions for LocalDate using DateUtils
 */

fun LocalDate.formatForDisplay(): String = DateUtils.formatDateForDisplay(this)

fun LocalDate.formatShort(): String = DateUtils.formatDateShort(this)

fun LocalDate.isToday(): Boolean = DateUtils.isToday(this)

fun LocalDate.isTomorrow(): Boolean = DateUtils.isTomorrow(this)

fun LocalDate.isYesterday(): Boolean = DateUtils.isYesterday(this)

fun LocalDate.getRelativeString(): String = DateUtils.getRelativeDateString(this)

fun LocalDate.addDays(days: Int): LocalDate = DateUtils.addDays(this, days)

fun LocalDate.subtractDays(days: Int): LocalDate = DateUtils.subtractDays(this, days)

fun LocalDate.daysUntil(other: LocalDate): Int = DateUtils.daysBetween(this, other)