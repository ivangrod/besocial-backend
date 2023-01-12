package org.besocial.besocialbackend.user

import org.besocial.besocialbackend.user.adapter.out.persistence.MongoDBUserRepository
import org.besocial.besocialbackend.user.adapter.out.persistence.MongoDBUsers
import org.besocial.besocialbackend.user.application.port.`in`.SignUp
import org.besocial.besocialbackend.user.application.port.out.Users
import org.besocial.besocialbackend.user.application.service.SignUpHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class UserInitializr {

    @Bean
    fun users(repository: MongoDBUserRepository): Users = MongoDBUsers(repository)

    @Bean
    fun signUp(users: Users): SignUp = SignUpHandler(users)
}
