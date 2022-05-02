package com.example.realestateapp.usecase

import com.example.realestateapp.data.model.House
import com.example.realestateapp.data.repository.HouseRepository
import com.example.realestateapp.usecase.mapper.HouseMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetHousesUseCaseImpl(
    private val repository: HouseRepository,
    private val mapper: HouseMapper
) : GetHousesUseCase {
    override suspend fun execute(): Flow<List<House>> {
        repository.loadHouses()
        return repository.showHouses().map { houses ->
            houses.map { mapper.map(it) }
        }
    }
}