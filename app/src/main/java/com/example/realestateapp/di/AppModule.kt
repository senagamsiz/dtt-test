package com.example.realestateapp.di

import android.app.Application
import androidx.room.Room
import com.example.realestateapp.BuildConfig
import com.example.realestateapp.data.local.dao.HouseDao
import com.example.realestateapp.data.local.database.AppDatabase
import com.example.realestateapp.data.remote.AuthInterceptor
import com.example.realestateapp.data.remote.api.HouseApi
import com.example.realestateapp.data.repository.HouseRepository
import com.example.realestateapp.data.repository.HouseRepositoryImpl
import com.example.realestateapp.ui.viewmodel.HousesOverviewViewModel
import com.example.realestateapp.usecase.GetHousesUseCaseImpl
import com.example.realestateapp.usecase.mapper.HouseMapper
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val appModules = module {
    factory { AuthInterceptor() }
    factory { provideOkHttpClient(get()) }
    factory { provideHouseApi(get()) }
    single { provideRetrofit(get()) }
    single { provideDatabase(androidApplication()) }
    single { provideDao(get()) }
    single { HouseRepositoryImpl(get(), get()) }
    single { HouseMapper() }
    single { GetHousesUseCaseImpl(get(), get()) }
    viewModel { HousesOverviewViewModel(get()) }

}


//Networking
private val contentType: MediaType = MediaType.get("application/json")

private val json = Json {
    ignoreUnknownKeys = true
    explicitNulls = false
    isLenient = true
}

private fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder().baseUrl(BuildConfig.API_URL)
        .addConverterFactory(
            json.asConverterFactory(contentType)
        ).client(okHttpClient).build()
}

private fun provideOkHttpClient(authInterceptor: AuthInterceptor): OkHttpClient {
    return OkHttpClient().newBuilder().addInterceptor(authInterceptor).build()
}

private fun provideHouseApi(retrofit: Retrofit): HouseApi =
    retrofit.create(HouseApi::class.java)

//Local
private fun provideDatabase(application: Application): AppDatabase {
    val DATABASE_NAME = "house_database"
    return Room.databaseBuilder(application, AppDatabase::class.java, DATABASE_NAME)
        .fallbackToDestructiveMigration()
        .build()
}

private fun provideDao(database: AppDatabase): HouseDao {
    return database.houseDao()
}