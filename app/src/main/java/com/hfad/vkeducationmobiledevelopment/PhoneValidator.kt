package com.hfad.vkeducationmobiledevelopment

object PhoneValidator {
    private val phoneRegex =
        """^[+\d](?:\d+(?:-\d+)*|\d+(?:-\d+)*\(\d+(?:-\d+)*\)\d+(?:-\d+)*)$""".toRegex()

    fun isValidPhone(phone: String): Boolean {
        return phone.matches(phoneRegex)
    }
}
