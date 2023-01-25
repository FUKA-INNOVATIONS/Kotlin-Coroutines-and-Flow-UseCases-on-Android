package com.fuka.coroutineusecasesonandroid.playground.fundamentals

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.runBlocking

// Everything running in the same thread (main)
// runBlocking:Runs a new coroutine and blocks the current thread interruptibly until its completion. This function should not be used from a coroutine.


fun main() = runBlocking {
    println("main starts")
    joinAll(
        async { threadInfoCoroutine(1, 500) },
        async { threadInfoCoroutine(2, 300) }
    )
    println("main ends")
}

suspend fun threadInfoCoroutine(number: Int, delay: Long) {
    println("Coroutine $number starts work on ${Thread.currentThread().name}")
    delay(delay)
    println("Coroutine $number has finished on ${Thread.currentThread().name}")
}