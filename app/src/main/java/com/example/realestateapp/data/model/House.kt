package com.example.realestateapp.data.model


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = "house_table")
data class House(

    @SerialName("base")
    val base: String,

    @PrimaryKey
    @SerialName("id")
    @ColumnInfo(name = "id")
    val id: Int,

    @SerialName("bath_rooms")
    @ColumnInfo(name = "bath_rooms")
    val bathrooms: Int,

    @SerialName("bed_rooms")
    @ColumnInfo(name = "bed_rooms")
    val bedrooms: Int,

    @SerialName("city")
    @ColumnInfo(name = "city")
    val city: String,

    @SerialName("created_date")
    @ColumnInfo(name = "created_date")
    val createdDate: String,

    @SerialName("description")
    @ColumnInfo(name = "description")
    val description: String,

    @SerialName("image")
    @ColumnInfo(name = "image")
    val image: String,

    @SerialName("latitude")
    @ColumnInfo(name = "latitude")
    val latitude: Int,

    @SerialName("longitude")
    @ColumnInfo(name = "longitude")
    val longitude: Int,

    @SerialName("price")
    @ColumnInfo(name = "price")
    val price: Int,

    @SerialName("size")
    @ColumnInfo(name = "size")
    val size: Int,

    @SerialName("zip")
    @ColumnInfo(name = "zip")
    val zip: String


)

