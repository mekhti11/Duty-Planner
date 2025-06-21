package com.example.dutyplanner.core.ui.theme

import androidx.compose.ui.graphics.Color


object DutyColors {

    // Primary gradient colors for headers
    val GradientStart = Color(0xFF667eea)
    val GradientEnd = Color(0xFF764ba2)

    // Shift Colors (Blue theme)
    val ShiftPrimary = Color(0xFF1976D2)
    val ShiftBackground = Color(0xFF2196F3).copy(alpha = 0.08f)
    val ShiftBorder = Color(0xFF2196F3).copy(alpha = 0.2f)

    // Leave Colors (Green theme)
    val LeavePrimary = Color(0xFF388E3C)
    val LeaveBackground = Color(0xFF4CAF50).copy(alpha = 0.08f)
    val LeaveBorder = Color(0xFF4CAF50).copy(alpha = 0.2f)

    // Meeting Colors (Orange theme)
    val MeetingPrimary = Color(0xFFF57C00)
    val MeetingBackground = Color(0xFFFF9800).copy(alpha = 0.08f)
    val MeetingBorder = Color(0xFFFF9800).copy(alpha = 0.2f)

    // Semantic colors
    val Success = Color(0xFF4CAF50)
    val Warning = Color(0xFFFF9800)
    val Error = Color(0xFFF44336)
    val Info = Color(0xFF2196F3)

    // Neutral colors
    val Gray50 = Color(0xFFFAFAFA)
    val Gray100 = Color(0xFFF5F5F5)
    val Gray200 = Color(0xFFEEEEEE)
    val Gray300 = Color(0xFFE0E0E0)
    val Gray400 = Color(0xFFBDBDBD)
    val Gray500 = Color(0xFF9E9E9E)
    val Gray600 = Color(0xFF757575)
    val Gray700 = Color(0xFF616161)
    val Gray800 = Color(0xFF424242)
    val Gray900 = Color(0xFF212121)
}