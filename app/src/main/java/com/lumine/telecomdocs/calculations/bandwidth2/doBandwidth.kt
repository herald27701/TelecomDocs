package com.lumine.telecomdocs.calculations.bandwidth2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class doBandwidth2 : ViewModel(){
    private var _isSuccessEvent: MutableLiveData<Double> = MutableLiveData()
    val isSuccessEvent: LiveData<Double>
        get() = _isSuccessEvent


    fun calculateBandwidth(Fmax: Double, Fmin: Double) {
        val bandwidth : Double = Fmax - Fmin

        _isSuccessEvent.postValue(bandwidth)

    }
}