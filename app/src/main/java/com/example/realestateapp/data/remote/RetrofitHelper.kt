package com.example.realestateapp.data.remote

import com.example.realestateapp.BuildConfig
import com.example.realestateapp.data.remote.api.HouseApi
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit

object RetrofitHelper {

    private val contentType: MediaType = MediaType.get("application/json")

    private val json = Json {
        ignoreUnknownKeys = true
        explicitNulls = false
        isLenient = true
    }

    private fun provideRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl(BuildConfig.API_URL)
            .addConverterFactory(
                json.asConverterFactory(contentType)
            ).client(provideOkHttpClient(AuthInterceptor())).build()
    }

    private fun provideOkHttpClient(authInterceptor: AuthInterceptor): OkHttpClient {
        return OkHttpClient().newBuilder().addInterceptor(authInterceptor).build()
    }

    fun provideHouseApi(): HouseApi =
        provideRetrofit().create(HouseApi::class.java)

}