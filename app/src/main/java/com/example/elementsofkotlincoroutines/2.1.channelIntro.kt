package com.example.elementsofkotlincoroutines

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random
import kotlin.random.nextUInt

suspend fun main() {
    val job = GlobalScope.launch {
        randomNumbersChannel().consumeEach {
            delay(Random.nextLong(1000L, 5000L))
            println(it)
            println("consumed")
        }
    }
    job.join()
}

fun CoroutineScope.randomNumbersChannel() = produce<UInt> {
    for (i in 1..100) {
        println("waiting to send")
        send(Random.nextUInt())
        println("sent")
    }
}

// we also have `offer()` that can be used in place of `send()` and this one doesn't block so the consumer can miss out on some objects in the channel.