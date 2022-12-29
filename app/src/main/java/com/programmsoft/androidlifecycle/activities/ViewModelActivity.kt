package com.programmsoft.androidlifecycle.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import by.kirich1409.viewbindingdelegate.viewBinding
import com.programmsoft.androidlifecycle.R
import com.programmsoft.androidlifecycle.databinding.ActivityViewModelBinding
import com.programmsoft.androidlifecycle.models.Currency
import com.programmsoft.androidlifecycle.utils.CurrencyViewModel
import com.programmsoft.androidlifecycle.utils.MyViewModel

class ViewModelActivity : AppCompatActivity(R.layout.activity_view_model) {
    private val binding: ActivityViewModelBinding by viewBinding()
    lateinit var myViewModel: MyViewModel
    lateinit var currencyViewModel: CurrencyViewModel
    var list = ArrayList<Currency>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.apply {
//            myViewModel = ViewModelProvider(this@ViewModelActivity)[MyViewModel::class.java]
//            myViewModel.get().observe(this@ViewModelActivity, Observer {
//                tv.text = it
//            })
//            btn.setOnClickListener {
//                val text = edit.text.toString()
//                myViewModel.set(text)
//            }
//            edit.addTextChangedListener {
//                myViewModel.set(it.toString())
//            }
            currencyViewModel =
                ViewModelProvider(this@ViewModelActivity).get(CurrencyViewModel::class.java)
            currencyViewModel.getCurrency().observe(this@ViewModelActivity, Observer {
                for (currency in it) {
                    list.add(currency)
                }
                Toast.makeText(this@ViewModelActivity, list[0].CcyNm_EN, Toast.LENGTH_SHORT)
                    .show()
            })
            binding.btn.setOnClickListener {
                Toast.makeText(this@ViewModelActivity, list.get(0).CcyNm_UZ, Toast.LENGTH_SHORT).show()
            }

        }
    }
}