package com.example.realestateapp.ui.viewmodel

import com.example.realestateapp.data.model.House

sealed class HousesOverviewUiState {
    data class HousesLoaded(val houses: List<House>) : HousesOverviewUiState()
}
