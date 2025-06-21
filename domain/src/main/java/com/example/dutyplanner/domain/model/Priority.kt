package com.example.dutyplanner.domain.model;

enum class Priority(val level: Int) {
    LOW(1),
    MEDIUM(2),
    HIGH(3),
    URGENT(4);
    
    val displayName: String
        get() = when (this) {
            LOW -> "Low"
            MEDIUM -> "Medium"
            HIGH -> "High"
            URGENT -> "Urgent"
        }
}