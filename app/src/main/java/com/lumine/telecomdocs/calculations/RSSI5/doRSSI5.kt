package com.lumine.telecomdocs.calculations.RSSI5

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class doRSSI5: ViewModel(){
    private var _isSuccessEvent: MutableLiveData<Double> = MutableLiveData()
    val isSuccessEvent: LiveData<Double>
        get() = _isSuccessEvent


    fun calculateRSSI(rssi_noise: Double,rssp_interpower: Double,rssp_serving_cell_power: Double)
    {
        val rssi: Double = rssi_noise + rssp_serving_cell_power + rssp_interpower

        _isSuccessEvent.postValue(rssi)

    }
}