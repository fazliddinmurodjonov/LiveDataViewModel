package com.programmsoft.androidlifecycle.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.Observer
import by.kirich1409.viewbindingdelegate.viewBinding
import com.programmsoft.androidlifecycle.R
import com.programmsoft.androidlifecycle.databinding.ActivityMainBinding
import com.programmsoft.androidlifecycle.utils.MyLiveData
import com.programmsoft.androidlifecycle.utils.MyObserver

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    private val binding: ActivityMainBinding by viewBinding()
    lateinit var myObserver: MyObserver
    lateinit var myLiveData: MyLiveData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        myObserver = MyObserver()
        this.lifecycle.addObserver(myObserver)
        myLiveData = MyLiveData()
        binding.apply {
            myLiveData.get().observe(this@MainActivity, Observer {
                tv.text = it
            })
            edit.addTextChangedListener {
                myLiveData.set(it.toString())
            }
//            btn.setOnClickListener {
//                val str = edit.text.toString()
//                myLiveData.set(str)
//            }
        }

    }

}