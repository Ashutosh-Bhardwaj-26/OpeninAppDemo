package com.example.openinappdemo.utils

import android.content.Context
import android.content.SharedPreferences
import com.example.openinappdemo.utils.Constants.USER_TOKEN
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class TokenManager @Inject constructor(
    private val sharedPreferences: SharedPreferences
) {
    init{
        val editor = sharedPreferences.edit();
        editor.putString(USER_TOKEN,"Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MjU5MjcsImlhdCI6MTY3NDU1MDQ1MH0.dCkW0ox8tbjJA2GgUx2UEwNlbTZ7Rr38PVFJevYcXFI")
        editor.apply()
    }

    fun getToken() : String?{
        return sharedPreferences.getString(USER_TOKEN,null)
    }

}