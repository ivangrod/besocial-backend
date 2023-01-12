package org.besocial.besocialbackend.user.domain

sealed class UserError(message: String): Error(message)

data class UserAlreadyExistError(val username: Username?, val email: Email?): UserError("There's already an user with the same username/email")
