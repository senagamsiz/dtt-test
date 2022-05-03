package com.example.realestateapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.realestateapp.usecase.GetHousesUseCase
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class HousesOverviewViewModel(private val useCase: GetHousesUseCase) : ViewModel() {

    private val _uiState = MutableLiveData<HousesOverviewUiState>()
    val uiState: LiveData<HousesOverviewUiState>
        get() = _uiState

    fun dispatch(event: HousesOverviewEvent) {
        when (event) {
            is HousesOverviewEvent.LoadData -> loadHousesData()
        }
    }

    private fun loadHousesData() = viewModelScope.launch {
        useCase.execute().collect { houses ->
            _uiState.value = HousesOverviewUiState.HousesLoaded(houses)
        }
    }

}