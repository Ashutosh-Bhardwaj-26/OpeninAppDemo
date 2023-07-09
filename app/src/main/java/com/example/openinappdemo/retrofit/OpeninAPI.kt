package com.example.openinappdemo.retrofit

import com.example.openinappdemo.models.User
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface OpeninAPI {
    @GET("dashboardNew")
    suspend fun getUserData( @Header("Authorization") token: String) : Response<ResponseBody>
}