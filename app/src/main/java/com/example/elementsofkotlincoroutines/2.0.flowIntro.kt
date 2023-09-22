package com.example.elementsofkotlincoroutines

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.job
import kotlinx.coroutines.launch
import java.util.concurrent.Flow
import kotlin.random.Random
import kotlin.random.nextUInt

suspend fun main() {
    val job = GlobalScope.launch(Dispatchers.Unconfined) {
        randomNumbersFlow().collect { println(it) }
    }
    job.join()
}


suspend fun randomNumbersFlow() = flow {
    for (i in 1..100){
        delay(100L)
        emit(Random.nextUInt())
    }
}