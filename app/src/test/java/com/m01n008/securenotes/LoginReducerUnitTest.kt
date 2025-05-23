package com.m01n008.securenotes

import com.m01n008.securenotes.presentation.login.LoginIntent
import com.m01n008.securenotes.presentation.login.LoginState
import com.m01n008.securenotes.presentation.login.reduceLogin
import org.junit.Test
import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class reduceLoginUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }
    @Test
    fun `correct pin should authenticate`(){
        val result = reduceLogin(LoginIntent.AttemptPinLogin("9876"), LoginState())
            assertTrue(result.isAuthenticated)
    }
}