package com.fuka.coroutineusecasesonandroid.playground.fundamentals

import kotlin.concurrent.thread

fun main() {
    println("main starts")
    threadRoutine(1, 500)
    threadRoutine(2, 300)
    Thread.sleep(1000)
    println("main ends")
}

fun threadRoutine(number: Int, delay: Long) {
    println("1. Thread name: ${Thread.currentThread().name}")
    thread {
        println("2. Thread name: ${Thread.currentThread().name}")
        println("Routine $number starts work")
        Thread.sleep(delay)
        println("3. Thread name: ${Thread.currentThread().name}")
        println("Routine $number has finished")
    }
}

/*
*   Allocated thread object consumes considerable amount of memory
*   Switching between thread is a very expensive operation
* */