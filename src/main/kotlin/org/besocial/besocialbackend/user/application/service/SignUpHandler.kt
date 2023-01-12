package org.besocial.besocialbackend.user.application.service

import arrow.core.Either
import org.besocial.besocialbackend.user.application.port.`in`.SignUp
import org.besocial.besocialbackend.user.application.port.out.Users
import org.besocial.besocialbackend.user.domain.*

class SignUpHandler(private val repository: Users) : SignUp {

    override fun execute(command: SignUp.SignUpCommand): Either<UserError, Unit> {

        val username = Username(command.username)
        val email = Email(command.email)

        return if (repository.findUserByUsernameOrEmail(username, email) != null) {
            Either.Left(UserAlreadyExistError(username, email))
        } else {
            repository.save(User.register(username, email))
            Either.Right(Unit)
        }
    }
}
