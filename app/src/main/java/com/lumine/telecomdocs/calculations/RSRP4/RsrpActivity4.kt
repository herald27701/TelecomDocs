package com.lumine.telecomdocs.calculations.RSRP4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lumine.telecomdocs.R
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.lumine.telecomdocs.databinding.ActivityRsrp4Binding

class RsrpActivity4 : AppCompatActivity() {

    private lateinit var binding: ActivityRsrp4Binding
    private lateinit var viewModel: doRSRP4

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_rsrp4)
        viewModel = ViewModelProvider(this).get(doRSRP4::class.java)

        binding.run.setOnClickListener { calculate() }
        listenerSuccessEvent()
    }

    private fun calculate()
    {
        val rssi_dbm: Double = binding.RSSIDBm.text.toString().trim().toDouble()
        val n: Double = binding.NArgument.text.toString().trim().toDouble()

        viewModel.calculateRSRP(rssi_dbm,n)
    }

    private fun listenerSuccessEvent() {
        viewModel.isSuccessEvent.observe(this) { value ->

            binding.result.text="RSRP : $value (dBm)"
        }
    }

}