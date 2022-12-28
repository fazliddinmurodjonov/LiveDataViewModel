package com.programmsoft.androidlifecycle.utils

import android.widget.Toast
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class MyObserver : LifecycleObserver {
    private val TAG = "MyObserver"

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun connectListener() {
        Toast.makeText(App.instance, "ON_RESUME", Toast.LENGTH_SHORT).show()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun disconnectListener() {
        Toast.makeText(App.instance, "ON_PAUSE", Toast.LENGTH_SHORT).show()
    }

}