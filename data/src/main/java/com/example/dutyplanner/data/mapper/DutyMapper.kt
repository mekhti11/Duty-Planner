package com.example.dutyplanner.data.mapper

import com.example.dutyplanner.data.local.entity.DutyEntity
import com.example.dutyplanner.domain.model.Duty
import com.example.dutyplanner.domain.model.DutyType


fun DutyEntity.toDomain(): Duty = Duty(
    id = id,
    title = title,
    date = date,
    type = DutyType.valueOf(type)
)

fun Duty.toEntity(): DutyEntity = DutyEntity(
    id = id,
    title = title,
    date = date,
    type = type.name
)