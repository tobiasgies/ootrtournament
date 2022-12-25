package de.tobiasgies.ootrtournament.web

import de.tobiasgies.ootrtournament.discord.DiscordTournamentSignupFlow
import de.tobiasgies.ootrtournament.entities.Tournament
import discord4j.common.util.Snowflake
import discord4j.core.GatewayDiscordClient
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/discord")
class DiscordSandboxController(
    private val gatewayDiscordClient: GatewayDiscordClient,
    private val signupFlow: DiscordTournamentSignupFlow
    ) {
    @PostMapping("/helloworld")
    fun helloworld(): Mono<String> {
        return gatewayDiscordClient.getChannelById(Snowflake.of("1051485104096157739"))
            .flatMap {
                it.restChannel.createMessage("Hello world!")
            }.map { 
                "Succesfully created message with ID ${it.id()}"
            }
    }

    @PostMapping("/signupmessage")
    fun signupmessage(): Mono<String> {
        return gatewayDiscordClient.getChannelById(Snowflake.of("1051485104096157739"))
            .flatMap {
                it.restChannel.createMessage(
                    signupFlow.buildSignupMessage(Tournament("Test Tournament"))
                )
            }.map {
                "Succesfully created message with ID ${it.id()}"
            }
    }
}