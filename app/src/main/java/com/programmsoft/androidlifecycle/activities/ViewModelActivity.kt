package com.programmsoft.androidlifecycle.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import by.kirich1409.viewbindingdelegate.viewBinding
import com.programmsoft.androidlifecycle.R
import com.programmsoft.androidlifecycle.databinding.ActivityViewModelBinding
import com.programmsoft.androidlifecycle.utils.MyViewModel

class ViewModelActivity : AppCompatActivity(R.layout.activity_view_model) {
    private val binding: ActivityViewModelBinding by viewBinding()
    lateinit var myViewModel: MyViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.apply {
            myViewModel = ViewModelProvider(this@ViewModelActivity)[MyViewModel::class.java]
            myViewModel.get().observe(this@ViewModelActivity, Observer {
                tv.text = it
            })
            btn.setOnClickListener {
                val text = edit.text.toString()
                myViewModel.set(text)
            }
//            edit.addTextChangedListener {
//                myViewModel.set(it.toString())
//            }
        }
    }
}