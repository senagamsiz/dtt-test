package com.example.realestateapp.ui.view.overview.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.realestateapp.data.model.House

class HouseDiffCallBack:DiffUtil.ItemCallback<House>() {
    override fun areItemsTheSame(oldItem: House, newItem: House): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: House, newItem: House): Boolean {
        return oldItem.id == newItem.id
    }
}