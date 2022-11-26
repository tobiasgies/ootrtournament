package de.tobiasgies.ootrtournament.discord

import discord4j.core.DiscordClient
import discord4j.core.GatewayDiscordClient
import discord4j.core.event.domain.lifecycle.ReadyEvent
import mu.KLogging
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import reactor.core.publisher.Mono

@Configuration
class DiscordConfiguration {

    @Bean
    fun discordClient(token: String) = DiscordClient.create(token)

    // TODO find the right mono method so this returns a GatewayDiscordClient, not a Void
    fun gatewayDiscordClient(discordClient: DiscordClient) = discordClient.login().map { client ->
        client.on(ReadyEvent::class.java) {
            Mono.fromRunnable<Void> {
                logger.info { "Connected to Discord as ${it.self.username}#${it.self.discriminator}." }
            }
        }
    }.block()

    companion object : KLogging()
}