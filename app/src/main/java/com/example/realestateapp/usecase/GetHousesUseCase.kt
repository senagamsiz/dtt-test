package com.example.realestateapp.usecase

import com.example.realestateapp.data.model.House
import kotlinx.coroutines.flow.Flow

interface GetHousesUseCase {
    suspend fun execute(): Flow<List<House>>
}