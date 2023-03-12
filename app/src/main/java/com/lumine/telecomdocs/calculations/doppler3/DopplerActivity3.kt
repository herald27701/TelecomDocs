package com.lumine.telecomdocs.calculations.doppler3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lumine.telecomdocs.R
import androidx.databinding.DataBindingUtil
import com.lumine.telecomdocs.databinding.ActivityDoppler3Binding
import androidx.lifecycle.ViewModelProvider

class DopplerActivity3 : AppCompatActivity() {

    private lateinit var binding: ActivityDoppler3Binding
    private lateinit var viewModel: doDoppler3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_doppler3)
        viewModel = ViewModelProvider(this).get(doDoppler3::class.java)

        binding.run.setOnClickListener { calculate() }
        listenerSuccessEvent()
    }

    private fun calculate()
    {
        val f0: Double = binding.dopplerF.text.toString().trim().toDouble()
        val v: Double = binding.dopplerV.text.toString().trim().toDouble()

        viewModel.calculateDoppler(f0,v)
    }

    private fun listenerSuccessEvent() {
        viewModel.isSuccessEvent.observe(this) { value ->

            binding.result.text="df : $value (Hz)"
        }
    }

}