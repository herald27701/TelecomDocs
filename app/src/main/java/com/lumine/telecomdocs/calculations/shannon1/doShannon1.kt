package com.lumine.telecomdocs.calculations.shannon1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.math.log2

class doShannon1 : ViewModel(){
    private var _isSuccessEvent: MutableLiveData<Double> = MutableLiveData()
    val isSuccessEvent: LiveData<Double>
        get() = _isSuccessEvent


    fun calculateChannelCapacity(bandwidth: Double, signalPower: Double, noisePower: Double) {
        val signalToNoiseRatio : Double = signalPower / noisePower
        val capacity : Double = bandwidth * log2(1.0 + signalToNoiseRatio)

        _isSuccessEvent.postValue(capacity)

    }
}