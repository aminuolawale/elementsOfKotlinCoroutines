package com.example.elementsofkotlincoroutines

import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        println("This is the first print statement inside the runBlocking")
        stallForTime(299L)
        println("This is the second print statement inside the runBlocking")
    }
    println("This gets printed last")
}

// If a coroutine fails within a CoroutineScope all other coroutines in that scope get cancelled.
// Using the SupervisorScope bypasses this rule.