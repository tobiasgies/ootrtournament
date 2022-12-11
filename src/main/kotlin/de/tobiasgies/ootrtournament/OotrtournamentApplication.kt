package de.tobiasgies.ootrtournament

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@SpringBootApplication
@ConfigurationPropertiesScan
class OotrtournamentApplication

fun main(args: Array<String>) {
	runApplication<OotrtournamentApplication>(*args)
}
