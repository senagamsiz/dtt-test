package com.example.realestateapp.data.repository

import com.example.realestateapp.data.model.House
import kotlinx.coroutines.flow.Flow

interface HouseRepository {
    suspend fun loadHouses()
    suspend fun showHouses(): Flow<List<House>>
}