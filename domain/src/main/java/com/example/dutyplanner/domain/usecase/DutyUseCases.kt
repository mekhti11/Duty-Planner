package com.example.dutyplanner.domain.usecase

data class DutyUseCases(
    val getDutiesForDate: GetDutiesForDateUseCase,
    val addDuty: AddDutyUseCase,
    val updateDuty: UpdateDutyUseCase,
    val deleteDuty: DeleteDutyUseCase,
    val getDutyStats: GetDutyStatsUseCase,
    val searchDuties: SearchDutiesUseCase,
    val validateDuty: ValidateDutyUseCase
)