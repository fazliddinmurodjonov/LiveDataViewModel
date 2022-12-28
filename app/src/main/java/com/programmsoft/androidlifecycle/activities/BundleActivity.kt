package com.programmsoft.androidlifecycle.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import by.kirich1409.viewbindingdelegate.viewBinding
import com.programmsoft.androidlifecycle.R
import com.programmsoft.androidlifecycle.databinding.ActivityBundleBinding

class BundleActivity : AppCompatActivity(R.layout.activity_bundle) {
    private val binding: ActivityBundleBinding by viewBinding()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.btn.setOnClickListener {
            binding.tv.text = binding.edit.text.toString()
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("name", binding.edit.text.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val a = savedInstanceState.getString("name")
        binding.tv.text = a
    }
}