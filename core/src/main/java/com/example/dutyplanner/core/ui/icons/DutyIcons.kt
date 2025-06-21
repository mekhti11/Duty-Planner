package com.example.dutyplanner.core.ui.icons

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.sharp.MailOutline
import androidx.compose.ui.graphics.vector.ImageVector

object DutyIcons {
    val Back = Icons.Default.ArrowBack
    val Menu = Icons.Default.Menu
    val Add = Icons.Default.Add
    val Delete = Icons.Default.Delete
    val Edit = Icons.Default.Edit
    val Save = Icons.Default.Done
    val List = Icons.Default.List
    val Event = Icons.Sharp.MailOutline
    val Schedule = Icons.Default.DateRange
    val Calendar = Icons.Default.DateRange
    val Person = Icons.Default.Person
    val Home = Icons.Default.Home
    val Settings = Icons.Default.Settings
    val Block = Icons.Default.Close
}

fun getDutyTypeIcon(dutyType: String): ImageVector {
    return when (dutyType.uppercase()) {
        "SHIFT" -> Icons.Default.DateRange
        "LEAVE" -> Icons.Default.Close
        "MEETING" -> Icons.Default.Person
        else -> Icons.Filled.Lock
    }
}