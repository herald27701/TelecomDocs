package com.lumine.telecomdocs.calculations.RSRQ6

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class doRSRQ6: ViewModel(){
    private var _isSuccessEvent: MutableLiveData<Double> = MutableLiveData()
    val isSuccessEvent: LiveData<Double>
        get() = _isSuccessEvent


    fun calculateRSRQ(rsrq_rssi: Double, rsrq_rsrp: Double, n_rb: Double)
    {
        val rsrq: Double = n_rb * (rsrq_rsrp/ rsrq_rssi)

        _isSuccessEvent.postValue(rsrq)

    }
}