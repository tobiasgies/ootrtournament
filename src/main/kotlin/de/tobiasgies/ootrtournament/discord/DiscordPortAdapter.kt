package de.tobiasgies.ootrtournament.discord

import discord4j.core.DiscordClient
import discord4j.core.GatewayDiscordClient
import org.reactivestreams.Publisher

class DiscordPortAdapter(discordClient: DiscordClient) {
    private val gatewayClient: GatewayDiscordClient

    init {
        // TODO replace with gatewayClient from DiscordConfiguration
        gatewayClient = discordClient.login().block()!!
    }

    private fun setupEventHandlers(gatewayDiscordClient: GatewayDiscordClient): Publisher<*> {
        TODO("Not yet implemented")
    }
}