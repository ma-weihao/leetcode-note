package top.wello.leetcode.coor

import kotlinx.coroutines.*
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine


fun main() {
    println("main in ${Thread.currentThread()}")
    GlobalScope.launch(Dispatchers.Default) {
        fetchUser()
        fetchInfo()
        println("i am launch in ${Thread.currentThread()}")
        val async = async {
            println("async succeed: ${Thread.currentThread()}")
        }
        println(locate())
        println("FINISH")
    }
    Thread.sleep(2000)
}

private suspend fun fetchUser() = withContext(Dispatchers.IO) {
    Thread.sleep(1000)
    println("fetchUser in ${Thread.currentThread()}")
}

private suspend fun fetchInfo() {
//    delay(1000)
    println("fetchInfo in ${Thread.currentThread()}")
}

private suspend fun locate(): String = suspendCoroutine {
    Thread.sleep(500)
    it.resume("DONE")
}