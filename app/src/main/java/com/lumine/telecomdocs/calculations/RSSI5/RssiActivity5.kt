package com.lumine.telecomdocs.calculations.RSSI5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lumine.telecomdocs.R
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.lumine.telecomdocs.databinding.ActivityRssi5Binding

class RssiActivity5 : AppCompatActivity() {

    private lateinit var binding: ActivityRssi5Binding
    private lateinit var viewModel: doRSSI5

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_rssi5)
        viewModel = ViewModelProvider(this).get(doRSSI5::class.java)

        binding.run.setOnClickListener { calculate() }
        listenerSuccessEvent()
    }

    private fun calculate()
    {
        val rssi_noise: Double = binding.rssiNoise.text.toString().trim().toDouble()
        val rssp_serving_cell_power: Double = binding.rssiSvcpwr.text.toString().trim().toDouble()
        val rssp_interpower: Double = binding.rssiInterPower.text.toString().trim().toDouble()

        viewModel.calculateRSSI(rssi_noise,rssp_serving_cell_power,rssp_interpower)
    }

    private fun listenerSuccessEvent() {
        viewModel.isSuccessEvent.observe(this) { value ->

            binding.result.text="RSSI = wideband power : $value"
        }
    }

}