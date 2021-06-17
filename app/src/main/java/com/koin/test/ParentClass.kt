package com.koin.test

sealed class ParentClass {

    object ChildClass : ParentClass() {
        fun test() {
            print("hello")
        }
    }
}