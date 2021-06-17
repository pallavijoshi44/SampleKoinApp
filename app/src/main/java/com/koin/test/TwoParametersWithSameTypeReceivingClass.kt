package com.koin.test

import android.util.Log
import androidx.lifecycle.ViewModel

class TwoParametersWithSameTypeReceivingClass(private val isFirstParameter: Boolean, private val isSecondParameter: Boolean) {
    fun test() {
        println("$isFirstParameter $isSecondParameter")
    }
}