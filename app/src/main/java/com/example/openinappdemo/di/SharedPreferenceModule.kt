package com.example.openinappdemo.di

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.example.openinappdemo.utils.Constants.MY_PREF
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class SharedPreferenceModule {

    @Provides
    fun provideSharedPreferences(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences(MY_PREF, Context.MODE_PRIVATE)
    }
}