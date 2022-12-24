package de.tobiasgies.ootrtournament.discord

import discord4j.core.DiscordClient
import discord4j.core.event.domain.lifecycle.GatewayLifecycleEvent
import discord4j.core.event.domain.lifecycle.ReadyEvent
import mu.KLogging
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import reactor.core.publisher.Mono

@Configuration
class DiscordConfiguration {
    @ConfigurationProperties(prefix = "discord")
    data class DiscordProperties(
        val token: String
    )

    @Bean
    fun discordClient(properties: DiscordProperties) = DiscordClient.create(properties.token)

    @Bean
    fun gatewayDiscordClient(discordClient: DiscordClient) =
        discordClient.login().doOnNext { client ->
            val connectedHandler = client.on(ReadyEvent::class.java) {
                Mono.fromRunnable<Void> {
                    logger.info { "Connection to Discord has become ready. " +
                            "Logged in as ${it.self.username}#${it.self.discriminator}." }
                }
            }.then()
            val lifecycleEventHandler = client.on(GatewayLifecycleEvent::class.java) {
                Mono.fromRunnable<Void> {
                    logger.debug { "Gateway lifecycle event received: $it - shard information: ${it.shardInfo}" }
                }
            }.then()
            connectedHandler.and(lifecycleEventHandler).subscribe()
        }.block()!!

    companion object : KLogging()
}