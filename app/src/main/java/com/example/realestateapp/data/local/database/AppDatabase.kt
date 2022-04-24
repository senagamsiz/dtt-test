package com.example.realestateapp.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.realestateapp.data.local.dao.HouseDao
import com.example.realestateapp.data.model.House

@Database(entities = [House::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun houseDao(): HouseDao

    companion object {

        // For Singleton instantiation
        @Volatile
        private var instance: AppDatabase? = null
        private const val DATABASE_NAME = "house_database"

        fun getInstance(context: Context): AppDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME)
                .build()
        }
    }
}