package top.wello.leetcode.coor

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.coroutines.*

/**
 * Created by maweihao on 4/5/22
 */
fun main() {
    val continuation = suspend {
        println("In Coroutine")
        5
    }.createCoroutine(object: Continuation<Int> {
        override val context: CoroutineContext
            get() = EmptyCoroutineContext

        override fun resumeWith(result: Result<Int>) {
            println("Coroutine end ${result.getOrThrow()}")
        }

    })
    continuation.resume(Unit)
    GlobalScope.launch {
        val requestToken = requestToken()
        requestToken(requestToken, requestToken)
    }
}

suspend fun requestToken(): Int {
    return 1
}

suspend fun requestToken(a: Int, b: Int): Int {
    return 1
}