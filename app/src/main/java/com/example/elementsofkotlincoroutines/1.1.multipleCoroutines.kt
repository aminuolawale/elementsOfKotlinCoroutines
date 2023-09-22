package com.example.elementsofkotlincoroutines

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.random.Random

suspend fun main() {
    val jobs = mutableListOf<Job>()
    for  (i in 1..100) {

        jobs.add( GlobalScope.launch(Dispatchers.Unconfined) {
            println("This is printed before delay $i")
            stallForTime(Random.nextLong(100, 5000))
            println("This is printed after delay $i")
        })

    }
    jobs.forEach { it.join() }
}
