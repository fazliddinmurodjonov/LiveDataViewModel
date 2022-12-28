package com.programmsoft.androidlifecycle.utils

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel :ViewModel() {
    private val liveData = MutableLiveData<String>()

    fun set(value: String) {
        liveData.value = value
    }

    fun get(): LiveData<String> {
        return liveData
    }
}