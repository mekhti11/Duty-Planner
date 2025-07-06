package com.example.dutyplanner.domain.usecase

import com.example.dutyplanner.domain.model.Duty
import com.example.dutyplanner.domain.repository.DutyRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class SearchDutiesUseCase @Inject constructor(
    private val repository: DutyRepository
) {
    operator fun invoke(query: String): Flow<List<Duty>> {
        val trimmedQuery = query.trim()
        require(trimmedQuery.length >= MIN_SEARCH_LENGTH) {
            "Search query must be at least $MIN_SEARCH_LENGTH characters"
        }

        return repository.searchDuties(trimmedQuery)
            .map { duties ->
                duties.sortedByDescending { duty ->
                    calculateRelevanceScore(duty, trimmedQuery)
                }
            }
    }
    
    private fun calculateRelevanceScore(duty: Duty, query: String): Int {
        val lowerQuery = query.lowercase()
        var score = 0
        
        if (duty.title.lowercase().contains(lowerQuery)) {
            score += 10
            if (duty.title.lowercase().startsWith(lowerQuery)) {
                score += 5
            }
        }
        
        if (duty.description?.lowercase()?.contains(lowerQuery) == true) {
            score += 3
        }
        
        if (duty.type.displayName.lowercase().contains(lowerQuery)) {
            score += 2
        }
        
        return score
    }
    
    companion object {
        const val MIN_SEARCH_LENGTH = 2
    }
}