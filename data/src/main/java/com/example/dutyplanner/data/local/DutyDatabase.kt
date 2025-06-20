package com.example.dutyplanner.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.dutyplanner.data.local.dao.DutyDao
import com.example.dutyplanner.data.local.entity.DutyEntity
import com.example.dutyplanner.data.util.LocalDateConverter

@Database(entities = [DutyEntity::class], version = 1)
@TypeConverters(LocalDateConverter::class)
abstract class DutyDatabase : RoomDatabase() {
    abstract fun dutyDao(): DutyDao
}