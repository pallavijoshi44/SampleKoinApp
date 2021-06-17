package com.koin.test

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.component.KoinComponent
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.core.parameter.parametersOf
import org.koin.core.qualifier.named
import org.koin.dsl.module

class CustomApplication : Application(), KoinComponent {

    companion object {
        val modules: List<Module> = listOf(
            appModule
        )
    }

    override fun onCreate() {
        super.onCreate()
        startKoin()
    }

    private fun startKoin() {
        startKoin {
            androidContext(this@CustomApplication)
            modules(modules)
        }
    }
}

const val NAMED_STRING: String = "hello"

val appModule: Module = module {
    factory(named(NAMED_STRING)) { "hello" }
    factory { StringParameterReceivingClass(get(named(NAMED_STRING))) }
    factory {
        TwoParametersWithSameTypeReceivingClass(it.get(), it.get())
    }
    //to test in checkmodules test
/*    factory {
       val x : TwoParametersWithSameTypeReceivingClass = get() { parametersOf(true, false)}
        x.test()
    }*/
    factory { ParameterReceivingClass(it.get()) }

    factory { SealedClassParameterReceivingClass(it.get()) }

    //to test in checkmodules test
    factory {
        val sealedClass : SealedClassParameterReceivingClass = get { parametersOf(ParentClass.ChildClass)}
        sealedClass.test()
    }


    viewModel {  SavedStateSampleViewModel(it.get()) }
}