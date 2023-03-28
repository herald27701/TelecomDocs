package com.lumine.telecomdocs.calculations.RSRP4

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.math.log10

class doRSRP4 : ViewModel(){
    private var _isSuccessEvent: MutableLiveData<Double> = MutableLiveData()
    val isSuccessEvent: LiveData<Double>
        get() = _isSuccessEvent


    fun calculateRSRP(rssi_dbm: Double, n: Double) {
        val rsrp: Double = rssi_dbm - 10.0 * log10(12*n)

        _isSuccessEvent.postValue(rsrp)

    }
}