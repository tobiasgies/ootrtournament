package de.tobiasgies.ootrtournament.discord

import discord4j.core.DiscordClient
import discord4j.core.GatewayDiscordClient
import org.reactivestreams.Publisher

class DiscordPortAdapter(private val gatewayClient: GatewayDiscordClient) {

    private fun setupEventHandlers(gatewayDiscordClient: GatewayDiscordClient): Publisher<*> {
        TODO("Not yet implemented")
    }
}