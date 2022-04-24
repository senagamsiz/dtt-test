package com.example.realestateapp.data.model


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "house_table")
data class House(

    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int,

    @ColumnInfo(name = "bath_rooms")
    val bathrooms: Int,

    @ColumnInfo(name = "bed_rooms")
    val bedrooms: Int,

    @ColumnInfo(name = "city")
    val city: String,

    @ColumnInfo(name = "created_Date")
    val createdDate: String,

    @ColumnInfo(name = "description")
    val description: String,

    @ColumnInfo(name = "image")
    val image: String,

    @ColumnInfo(name = "latitude")
    val latitude: Int,

    @ColumnInfo(name = "longitude")
    val longitude: Int,

    @ColumnInfo(name = "price")
    val price: Int,

    @ColumnInfo(name = "size")
    val size: Int,

    @ColumnInfo(name = "zip")
    val zip: String
)

