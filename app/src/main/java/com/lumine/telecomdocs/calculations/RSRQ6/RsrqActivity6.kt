package com.lumine.telecomdocs.calculations.RSRQ6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lumine.telecomdocs.R
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.lumine.telecomdocs.databinding.ActivityRsrq6Binding


class RsrqActivity6 : AppCompatActivity() {

    private lateinit var binding: ActivityRsrq6Binding
    private lateinit var viewModel: doRSRQ6

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_rsrq6)
        viewModel = ViewModelProvider(this).get(doRSRQ6::class.java)

        binding.run.setOnClickListener { calculate() }
        listenerSuccessEvent()
    }

    private fun calculate()
    {
        val rsrq_rssi: Double = binding.rsrqRssi.text.toString().trim().toDouble()
        val rsrq_rsrp: Double = binding.rsrqRsrp.text.toString().trim().toDouble()
        val n_rb: Double = binding.NRb.text.toString().trim().toDouble()

        viewModel.calculateRSRQ(rsrq_rssi,rsrq_rsrp,n_rb)
    }

    private fun listenerSuccessEvent() {
        viewModel.isSuccessEvent.observe(this) { value ->

            binding.result.text="RSRQ= : $value"
        }
    }

}