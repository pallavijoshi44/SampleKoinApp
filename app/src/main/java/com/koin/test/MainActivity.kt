package com.koin.test

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.stateViewModel
import org.koin.core.parameter.parametersOf
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity: AppCompatActivity(R.layout.activity_main) {

   // private val parameterReceivingClass: ParameterReceivingClass by inject()
   // private val twoParametersReceivingClass: TwoParametersWithSameTypeReceivingClass by inject { parametersOf(true, false) }
   // private val sealedClassParameterReceivingClass: SealedClassParameterReceivingClass by inject { parametersOf(ParentClass.ChildClass) }
    private val savedStateSameTypeReceivingClass: SavedStateSampleViewModel by stateViewModel()

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        //twoParametersReceivingClass.test()
    }
}