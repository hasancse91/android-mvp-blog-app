package com.hellohasan.mvpblog

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        val pass = "9834u jkdfhFD *"
        assertEquals(false, isPasswordStrong("3434 %55 45"))
        assertEquals(true, isPasswordStrong("3434 %55 A 3d45"))
        assertEquals(false, isPasswordStrong("AAAAAA"))
        assertEquals(false, isPasswordStrong("aaaaaadfdfdf"))
        assertEquals(false, isPasswordStrong("3434 %55 45"))
        assertEquals(false, isPasswordStrong("3434 %55 45"))
    }
}

fun isPasswordStrong(password: String) : Boolean {
    return true
}