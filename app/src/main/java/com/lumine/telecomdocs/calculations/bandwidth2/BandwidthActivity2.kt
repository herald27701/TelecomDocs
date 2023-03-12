package com.lumine.telecomdocs.calculations.bandwidth2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lumine.telecomdocs.R
import androidx.databinding.DataBindingUtil
import com.lumine.telecomdocs.databinding.ActivityBandwidth2Binding
import androidx.lifecycle.ViewModelProvider

class BandwidthActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityBandwidth2Binding
    private lateinit var viewModel: doBandwidth2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_bandwidth2)
        viewModel = ViewModelProvider(this).get(doBandwidth2::class.java)

        binding.run.setOnClickListener { calculate() }
        listenerSuccessEvent()
    }

    private fun calculate()
    {
        val Fmax: Double = binding.bandwidthFmax.text.toString().trim().toDouble()
        val Fmin: Double = binding.bandwidthFmin.text.toString().trim().toDouble()

        viewModel.calculateBandwidth(Fmax,Fmin)
    }

    private fun listenerSuccessEvent() {
        viewModel.isSuccessEvent.observe(this) { value ->

            binding.result.text="Bandwidth : $value (Hz)"
        }
    }

}