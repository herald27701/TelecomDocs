package com.lumine.telecomdocs.calculations.shannon1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lumine.telecomdocs.R
import androidx.databinding.DataBindingUtil
import com.lumine.telecomdocs.databinding.ActivityShannon1Binding
import androidx.lifecycle.ViewModelProvider

class ShannonActivity1 : AppCompatActivity() {

    private lateinit var binding: ActivityShannon1Binding
    private lateinit var viewModel: doShannon1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_shannon1)
        viewModel = ViewModelProvider(this).get(doShannon1::class.java)

        binding.run.setOnClickListener { calculate() }
        listenerSuccessEvent()
    }

    private fun calculate()
    {
        val bandwidth: Double = binding.shannonBandwidth.text.toString().trim().toDouble()
        val signalPower: Double = binding.shannonSignalpower.text.toString().trim().toDouble()
        val noisePower: Double = binding.shannonNoisepower.text.toString().trim().toDouble()

        viewModel.calculateChannelCapacity(bandwidth, signalPower, noisePower)
    }

    private fun listenerSuccessEvent() {
        viewModel.isSuccessEvent.observe(this) { value ->

            binding.shannonCapacity.setText("$value")
        }
    }

}