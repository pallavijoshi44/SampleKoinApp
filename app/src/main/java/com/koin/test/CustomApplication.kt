package com.koin.test

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.component.KoinComponent
import org.koin.core.context.startKoin
import org.koin.core.module.Module
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
    factory { TwoParametersWithSameTypeReceivingClass(it.get(), it.get()) }
    factory { ParameterReceivingClass(it.get()) }
 //Failing one
    factory { SealedClassParameterReceivingClass(it.get()) }

//    factory { (parameter: ParentClass) ->
//        SealedClassParameterReceivingClass(parameter)
//    }
}