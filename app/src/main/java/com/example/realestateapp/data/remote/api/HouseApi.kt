package com.example.realestateapp.data.remote.api

import com.example.realestateapp.data.model.House
import retrofit2.http.GET

interface HouseApi {
    @GET("house")
    suspend fun getHouseFromApi(): List<House>
}
