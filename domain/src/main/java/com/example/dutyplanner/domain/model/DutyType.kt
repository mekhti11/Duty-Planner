package com.example.dutyplanner.domain.model

enum class DutyType {
    SHIFT,
    LEAVE,
    MEETING;

    val displayName: String
        get() = when (this) {
            SHIFT -> "Shift"
            LEAVE -> "Leave"
            MEETING -> "Meeting"
        }
}