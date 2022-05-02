package com.example.realestateapp.data.repository

import com.example.realestateapp.data.local.dao.HouseDao
import com.example.realestateapp.data.model.House
import com.example.realestateapp.data.remote.api.HouseApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class HouseRepositoryImpl(
    private val houseDao: HouseDao,
    private val houseApi: HouseApi
) : HouseRepository {

    override suspend fun loadHouses() {
        withContext(Dispatchers.IO) {
            val houseList = houseApi.getHouseFromApi().toTypedArray()
            houseDao.insertAllHouses(*houseList)
        }
    }

    override suspend fun showHouses(): Flow<List<House>> {
        return houseDao.getAllHousesByPrice()
    }

}