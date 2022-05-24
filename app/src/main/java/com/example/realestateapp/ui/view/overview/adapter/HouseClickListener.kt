package com.example.realestateapp.ui.view.overview.adapter

import com.example.realestateapp.data.model.House

class HouseClickListener(val clickListener:(house: House) -> Unit) {
    fun onClick(house: House) = clickListener(house)
}