package com.lumine.telecomdocs.calculations.doppler3

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

const val c = 299792458
class doDoppler3 : ViewModel(){
    private var _isSuccessEvent: MutableLiveData<Double> = MutableLiveData()
    val isSuccessEvent: LiveData<Double>
        get() = _isSuccessEvent


    fun calculateDoppler(f0: Double, v: Double) {
        val df: Double = f0 *(v/c)

        _isSuccessEvent.postValue(df)

    }
}