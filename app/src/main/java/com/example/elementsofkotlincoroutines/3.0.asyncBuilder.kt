package com.example.elementsofkotlincoroutines

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

suspend fun main() {
    val job = GlobalScope.launch (Dispatchers.Unconfined) {
        val deferredString :Deferred<String> = GlobalScope.async(Dispatchers.Unconfined) {
            delay(2000L)
            "Just the return value from this function"
        }
        val string = deferredString.await()
        println("This is the string \n$string")
    }
    println("This is printed immediately")
    job.join()
}