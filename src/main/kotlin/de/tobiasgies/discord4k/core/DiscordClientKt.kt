package de.tobiasgies.discord4k.core

import discord4j.core.DiscordClient
import discord4j.core.GatewayDiscordClient
import kotlinx.coroutines.channels.SendChannel
import kotlinx.coroutines.reactive.publish
import kotlinx.coroutines.reactor.awaitSingle
import kotlinx.coroutines.reactor.mono

class DiscordClientKt(val java: DiscordClient) {
    val DiscordClient.kotlin: DiscordClientKt
        get() = DiscordClientKt(this)

    suspend fun login(): GatewayDiscordClient = java.login().awaitSingle()

    suspend fun withGateway(whileConnectedFunction: suspend (GatewayDiscordClient) -> Any?) {
        java.withGateway { client ->
            mono {
                whileConnectedFunction(client)
            }
        }.awaitSingle()
    }

    suspend fun <E> withGateway(
        whileConnectedFunction: suspend (GatewayDiscordClient, SendChannel<E>) -> Unit
    ) {
        java.withGateway { client ->
            publish {
                whileConnectedFunction(client, this)
            }
        }.awaitSingle()
    }

}
