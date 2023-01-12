package org.besocial.besocialbackend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

@SpringBootApplication
@EnableMongoRepositories(repositoryImplementationPostfix = "Custom")
class BesocialBackendApplication

fun main(args: Array<String>) {
	runApplication<BesocialBackendApplication>(*args)
}
