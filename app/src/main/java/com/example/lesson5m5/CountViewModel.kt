package com.example.lesson5m5

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lesson1m5.CounterModel

class CountViewModel : ViewModel() {

    private val model = CounterModel()

    val counterData = MutableLiveData<Int>()
    val message = MutableLiveData<String>()
    val textColor = MutableLiveData<Int>(R.color.black)

    fun increment() {
        model.increment()
        counterData.value = model.getResult()
        updateToastAndColor()
    }

    fun decrement() {
        model.decrement()
        counterData.value = model.getResult()
        updateToastAndColor()
    }

    private fun updateToastAndColor() {
        if (counterData.value==10) {
            message.value = "Поздравляем!"
        }
        if (counterData.value==15){
            textColor.value = R.color.green
        } else{
            textColor.value = R.color.black
        }
    }
}