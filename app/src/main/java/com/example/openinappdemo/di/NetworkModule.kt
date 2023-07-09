package com.example.openinappdemo.di

import com.example.openinappdemo.retrofit.OpeninAPI
import com.example.openinappdemo.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {


    @Provides
    fun provideRetrofit() : Retrofit{
        return Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    @Provides
    fun providesOpeninAPI(retrofit: Retrofit) : OpeninAPI {
        return retrofit.create(OpeninAPI::class.java)
    }
}
