package org.besocial.besocialbackend.user.application.port.`in`

import arrow.core.Either
import org.besocial.besocialbackend.user.domain.User
import org.besocial.besocialbackend.user.domain.UserError

interface SignUp {

    fun execute(command: SignUpCommand): Either<UserError, Unit>

    data class SignUpCommand(val username: String, val email: String)
}
