package com.programmsoft.androidlifecycle.utils

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.programmsoft.androidlifecycle.models.Currency
import com.programmsoft.androidlifecycle.retrofit.ApiClient
import retrofit2.Call
import retrofit2.Response

class CurrencyViewModel : ViewModel() {

    private val liveData = MutableLiveData<List<Currency>>()

    fun getCurrency(): LiveData<List<Currency>> {
        ApiClient.apiService.getCurrency().enqueue(object : retrofit2.Callback<List<Currency>> {
            override fun onResponse(
                call: Call<List<Currency>>,
                response: Response<List<Currency>>,
            ) {
                if (response.isSuccessful) {
                    liveData.value = response.body()
                }
            }
            override fun onFailure(call: Call<List<Currency>>, t: Throwable) {
            }
        })
        return liveData
    }

    fun get(): LiveData<List<Currency>> {
        return liveData
    }

}