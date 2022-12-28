package com.programmsoft.androidlifecycle.retrofit

import com.programmsoft.androidlifecycle.models.Currency
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("json")
    fun getCurrency(): Call<List<Currency>>
}