package com.example.dutyplanner.data.repository

import com.example.dutyplanner.data.local.dao.DutyDao
import com.example.dutyplanner.data.mapper.toDomain
import com.example.dutyplanner.data.mapper.toEntity
import com.example.dutyplanner.domain.model.Duty
import com.example.dutyplanner.domain.repository.DutyRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.datetime.LocalDate

class DutyRepositoryImpl(
    private val dao: DutyDao
) : DutyRepository {
    override suspend fun addDuty(duty: Duty) {
        dao.insert(duty.toEntity())
    }

    override fun getDutiesForDate(date: LocalDate): Flow<List<Duty>> {
        return dao.getByDate(date).map { it -> it.map { it.toDomain() } }
    }

    override fun getDutiesForRange(start: LocalDate, end: LocalDate): Flow<List<Duty>> {
        return dao.getByRange(start, end).map { it -> it.map { it.toDomain() } }
    }

    override suspend fun deleteDuty(id: Int) {
        dao.delete(id)
    }
}