package com.example.dutyplanner.data.local.dao

import androidx.room.*
import com.example.dutyplanner.data.local.entity.DutyEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.datetime.LocalDate

@Dao
interface DutyDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(duty: DutyEntity)

    @Query("SELECT * FROM duties WHERE date = :date")
    fun getByDate(date: LocalDate): Flow<List<DutyEntity>>

    @Query("SELECT * FROM duties WHERE date BETWEEN :start AND :end")
    fun getByRange(start: LocalDate, end: LocalDate): Flow<List<DutyEntity>>

    @Query("DELETE FROM duties WHERE id = :id")
    suspend fun delete(id: Int)
}
