package de.tobiasgies.ootrtournament.discord

import discord4j.core.DiscordClient
import discord4j.core.GatewayDiscordClient
import discord4j.core.event.domain.lifecycle.ConnectEvent
import discord4j.core.event.domain.lifecycle.DisconnectEvent
import discord4j.core.event.domain.lifecycle.GatewayLifecycleEvent
import discord4j.core.event.domain.lifecycle.ReadyEvent
import discord4j.core.event.domain.lifecycle.ReconnectEvent
import discord4j.core.event.domain.lifecycle.ReconnectFailEvent
import discord4j.core.event.domain.lifecycle.ReconnectStartEvent
import discord4j.core.event.domain.lifecycle.SessionInvalidatedEvent
import mu.KLogging
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import reactor.core.publisher.Mono

@Configuration
class DiscordConfiguration {

    @Bean
    fun discordClient(token: String) = DiscordClient.create(token)

    @Bean
    fun gatewayDiscordClient(discordClient: DiscordClient) =
        discordClient.login().doOnNext { client ->
            client.on(ReadyEvent::class.java) {
                Mono.fromRunnable<Void> {
                    logger.info { "Connection to Discord has become rady. " +
                            "Logged in as ${it.self.username}#${it.self.discriminator}." }
                }
            }.subscribe()
            client.on(GatewayLifecycleEvent::class.java) {
                Mono.fromRunnable<Void> {
                    logger.debug { "Gateway lifecycle event received: $it - shard information: ${it.shardInfo}" }
                }
            }.subscribe()
        }.block()!!

    companion object : KLogging()
}