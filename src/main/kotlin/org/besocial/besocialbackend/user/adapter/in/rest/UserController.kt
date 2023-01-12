package org.besocial.besocialbackend.user.adapter.`in`.rest

import jakarta.validation.Valid
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import org.besocial.besocialbackend.user.application.port.`in`.SignUp
import org.besocial.besocialbackend.user.domain.UserAlreadyExistError
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController("/api")
class UserController(private val signUp: SignUp) {

    @PostMapping("/signup")
    fun signUp(@Valid @RequestBody signUpRequest: SignUpRequest): ResponseEntity<String> {
        return signUp.execute(SignUp.SignUpCommand(signUpRequest.username, signUpRequest.email)).fold(
            ifRight = { ResponseEntity.ok().build() },
            ifLeft = {
                when (it) {
                    is UserAlreadyExistError -> ResponseEntity.badRequest().body(it.message)
                }
            })
    }

    data class SignUpRequest(
        @field:NotNull(message = "The username is required.") @field:Size(min = 4, max = 16) val username: String,
        @field:NotNull(message = "The email is required.") @field:Email val email: String
    )
}
