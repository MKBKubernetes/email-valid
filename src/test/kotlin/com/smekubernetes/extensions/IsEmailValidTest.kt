package com.smekubernetes.extensions

import org.junit.jupiter.api.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class IsEmailValidTest {

    @Test
    fun isEmailValid() {
        assertTrue("someemail+test@test.test".isEmailValid())
        assertTrue("someemail+t.e.s.t@test.test".isEmailValid())
        assertFalse("someemail+t.e.s.t.@test.test".isEmailValid()) //part before the @ cannot end with .
        assertFalse("someemail+t..e.s.t@test.test".isEmailValid()) //.. is not allowed
        assertTrue("χρήστης@παράδειγμα.ελ".isEmailValid())
        assertTrue("用户@例子.广告".isEmailValid())
        assertTrue("ab!c@example.com".isEmailValid())
        assertTrue("!#$%&'*+-/=?^_`.{|}~@example.com".isEmailValid())
        assertTrue("user+mailbox/department=shipping@example.com".isEmailValid())
    }
}
