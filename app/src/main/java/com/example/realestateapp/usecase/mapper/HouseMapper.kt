package com.example.realestateapp.usecase.mapper

import com.example.realestateapp.data.model.House

class HouseMapper {

    companion object {
        private const val BASE_URL = "https://intern.development.d-tt.dev"
    }

    fun map(house: House): House {
        val imageUrl = BASE_URL + house.image
        return house.copy(image = imageUrl)
    }
}