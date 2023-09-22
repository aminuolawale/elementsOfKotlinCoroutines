package com.example.elementsofkotlincoroutines


import kotlinx.coroutines.*
suspend fun main() {
    println("This is printed immediately")
    val j1 =  GlobalScope.launch ( Dispatchers.Unconfined){
        println("This is printed before the delay 1")
        stallForTime(3999L

        )
        println("This is printed after the delay 1")
    }
    val j2 =  GlobalScope.launch ( Dispatchers.Unconfined){
        println("This is printed before the delay 2")
        stallForTime(2000L)
        println("This is printed after the delay 2")
    }
    val j3 =  GlobalScope.launch ( Dispatchers.Unconfined){
        println("This is printed before the delay 3")
        stallForTime(299L)
        println("This is printed after the delay 3")
    }
    j1.join()
    j2.join()
    j3.join()
}

suspend fun stallForTime(delayVal: Long) {
    withContext(Dispatchers.Unconfined) {
        delay(delayVal)
    }
}