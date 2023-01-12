package org.besocial.besocialbackend.user.domain

import java.math.BigInteger
import java.security.MessageDigest

data class UserId(val value: String){

    companion object {

        fun fromEmail(email: Email): UserId {
            val md: MessageDigest = MessageDigest.getInstance("MD5")
            md.update(email.value.toByteArray(charset("UTF-8")), 0, email.value.length)
            return UserId(BigInteger(1, md.digest()).toString(16))
        }
    }
}
