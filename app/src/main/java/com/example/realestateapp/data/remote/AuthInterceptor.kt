package com.example.realestateapp.data.remote

import com.example.realestateapp.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor : Interceptor {
    companion object {
        private const val ACCESS_KEY = "Access-Key"
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        val req = chain
            .request()
            .newBuilder()
            .addHeader(ACCESS_KEY, BuildConfig.API_KEY)
            .build()
        return chain.proceed(req)
    }
}