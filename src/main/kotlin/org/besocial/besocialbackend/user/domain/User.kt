package org.besocial.besocialbackend.user.domain

data class User(
    val id: UserId,
    val username: Username,
    val email: Email
) {

    companion object {

        fun register(
            username: Username,
            email: Email
        ): User = User(UserId.fromEmail(email), username, email)
    }
}
