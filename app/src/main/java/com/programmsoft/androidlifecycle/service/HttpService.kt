package com.programmsoft.androidlifecycle.service

import com.programmsoft.androidlifecycle.models.Currency
import com.programmsoft.androidlifecycle.retrofit.ApiClient
import retrofit2.Call
import retrofit2.Response

object HttpService {

    fun getCurrency(): List<Currency> {
        var list = ArrayList<Currency>()
        ApiClient.apiService.getCurrency().enqueue(object : retrofit2.Callback<List<Currency>> {
            override fun onResponse(
                call: Call<List<Currency>>,
                response: Response<List<Currency>>,
            ) {
                if (response.isSuccessful) {
                    list.addAll(response.body() ?: emptyList())
                }
            }

            override fun onFailure(call: Call<List<Currency>>, t: Throwable) {

            }

        })
        return list
    }

}