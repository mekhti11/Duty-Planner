package com.example.dutyplanner.domain.usecase

import com.example.dutyplanner.domain.model.Duty
import com.example.dutyplanner.domain.model.DutyType
import kotlinx.datetime.toLocalDateTime
import javax.inject.Inject

data class DutyStats(
    val totalCount: Int,
    val shiftCount: Int,
    val leaveCount: Int,
    val meetingCount: Int,
    val completedCount: Int,
    val completionRate: Float,
    val upcomingCount: Int,
    val overdueCount: Int
)

class GetDutyStatsUseCase @Inject constructor() {

    operator fun invoke(duties: List<Duty>): DutyStats {
        val now = kotlinx.datetime.Clock.System.now()
        val today = now.toLocalDateTime(kotlinx.datetime.TimeZone.currentSystemDefault()).date

        return DutyStats(
            totalCount = duties.size,
            shiftCount = duties.count { it.type == DutyType.SHIFT },
            leaveCount = duties.count { it.type == DutyType.LEAVE },
            meetingCount = duties.count { it.type == DutyType.MEETING },
            completedCount = duties.count { it.isCompleted },
            completionRate = if (duties.isNotEmpty()) {
                duties.count { it.isCompleted }.toFloat() / duties.size
            } else 0f,
            upcomingCount = duties.count { it.date > today && !it.isCompleted },
            overdueCount = duties.count { it.date < today && !it.isCompleted }
        )
    }
}