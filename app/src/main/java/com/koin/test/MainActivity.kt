package com.koin.test

import androidx.appcompat.app.AppCompatActivity
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity: AppCompatActivity(R.layout.activity_main) {

    private val parameterReceivingClass: ParameterReceivingClass by inject { parametersOf(true) }
    private val twoParametersReceivingClass: TwoParametersWithSameTypeReceivingClass by inject { parametersOf(true, false) }
    private val sealedClassParameterReceivingClass: SealedClassParameterReceivingClass by inject { parametersOf(ParentClass.ChildClass) }
}