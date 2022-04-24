package com.example.realestateapp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.realestateapp.data.model.House
import kotlinx.coroutines.flow.Flow


@Dao
interface HouseDao {

    @Query("SELECT * FROM house_table ORDER BY price")
    fun getAllHousesByPrice(): Flow<List<House>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllHouses(vararg house: House)

}