package com.example.realestateapp.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.realestateapp.data.local.dao.HouseDao
import com.example.realestateapp.data.model.House

@Database(entities = [House::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun houseDao(): HouseDao
}