package com.koin.test

import io.mockk.mockk
import org.junit.Test
import org.junit.experimental.categories.Category
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.koin.test.category.CheckModuleTest
import org.koin.test.check.checkModules

@Category(CheckModuleTest::class)
class CheckModulesTest : KoinTest {

    @Test
    fun checkAllModules() {
        checkModules {
            androidContext(mockk())
            modules(appModule)
        }
        stopKoin()
    }
}


