package com.example.animal
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {
    val retrofitInstance: Retrofit
        get() {
            val loggingInterceptor = HttpLoggingInterceptor()
            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor((loggingInterceptor))
                .build()
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

            return  Retrofit.Builder()
                .baseUrl("https://data.taipei")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()
        }
}