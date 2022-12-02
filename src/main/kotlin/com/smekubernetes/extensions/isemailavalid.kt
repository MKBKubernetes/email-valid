package com.smekubernetes.extensions

import java.util.regex.Pattern

/**
 * Valid but unsupported:
 * - "Fred\ Bloggs"@example.com
 * - "Joe.\\Blow"@example.com
 *
 * The regex does not support " and the chars that are allowed inside the quoted area like (),:;<>@[\]
 */
fun String.isEmailValid(): Boolean {
    return Pattern.compile(
        """
            ^(([\p{L}0-9_!#$%&'*+/=?^`{|}~-]+[.+])+[\p{L}0-9_!#$%&'*+/=?^`{|}~-]+|(\p{L}|[\p{L}0-9_!#$%&'*+/=?^`{|}~-]{2,}))@((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9]|[\p{L}0-9]+[\p{L}-0-9]*)\.([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\.([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\.([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9]))|([\p{L}0-9]+[\p{L}-0-9]*\.)+\p{L}{2,10})$
        """.trimIndent()
    ).matcher(this).matches()
}
