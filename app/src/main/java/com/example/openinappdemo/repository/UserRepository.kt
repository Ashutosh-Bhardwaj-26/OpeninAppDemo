package com.example.openinappdemo.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.openinappdemo.models.User
import com.example.openinappdemo.retrofit.OpeninAPI
import com.example.openinappdemo.utils.TokenManager
import com.google.gson.Gson
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val openinAPI: OpeninAPI,
    private val tokenManager : TokenManager
    ) {
    private val _users = MutableLiveData<User>()
    val users : LiveData<User>
    get() = _users

    suspend fun getUsersData() {
        try {
            val result = openinAPI.getUserData(tokenManager.getToken()!!)
            if (result.isSuccessful && result.body()  != null) {
                var gson = Gson()
                var user : User = gson.fromJson(result.body()!!.string(),User::class.java)
                _users.postValue(user)
            }
        } catch (e: Exception) {
            Log.d("data", e.toString())
        }
    }
}