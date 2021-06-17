package com.koin.test

class SealedClassParameterReceivingClass(private val parentClass: ParentClass.ChildClass) {
    fun test() {
        print("${(parentClass as ParentClass.ChildClass).test()}")
    }
}