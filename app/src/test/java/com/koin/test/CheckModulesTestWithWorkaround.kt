package com.koin.test

import io.mockk.mockk
import io.mockk.mockkClass
import org.junit.Rule
import org.junit.Test
import org.junit.experimental.categories.Category
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.koin.test.category.CheckModuleTest
import org.koin.test.check.checkModules
import org.koin.test.mock.MockProviderRule

@Category(CheckModuleTest::class)
class CheckModulesTestWithWorkaround : KoinTest {

    @get:Rule
    val mockProvider = MockProviderRule.create { clazz ->
        when (clazz) {
            String::class -> "hello"
            else -> mockkClass(clazz, relaxed = true)
        }
    }

    @Test
    fun checkAllModules() {
        checkModules(
            allowedMocks = listOf(
                Boolean::class,
                ParentClass.ChildClass::class,
                androidx.lifecycle.SavedStateHandle::class
            )
        ) {
            androidContext(mockk())
            modules(appModule)
        }
        stopKoin()
    }
}


