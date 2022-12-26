package de.tobiasgies.discord4k.core

import de.tobiasgies.discord4k.core.retriever.EntityRetrieverKt
import discord4j.common.util.Snowflake
import discord4j.core.GatewayDiscordClient
import discord4j.core.event.ReactiveEventAdapter
import discord4j.core.event.domain.Event
import discord4j.core.`object`.presence.ClientPresence
import discord4j.core.retriever.EntityRetrievalStrategy
import discord4j.core.spec.GuildCreateSpec
import discord4j.core.spec.UserEditSpec
import discord4j.discordjson.json.gateway.RequestGuildMembers
import kotlinx.coroutines.channels.SendChannel
import kotlinx.coroutines.reactive.asFlow
import kotlinx.coroutines.reactive.publish
import kotlinx.coroutines.reactor.awaitSingle
import kotlinx.coroutines.reactor.mono
import kotlin.reflect.KClass

val GatewayDiscordClient.kotlin: GatewayDiscordClientKt
    get() = GatewayDiscordClientKt.wrap(this)

class GatewayDiscordClientKt(override val java: GatewayDiscordClient) : EntityRetrieverKt {
    val rest: DiscordClientKt
        get() = java.rest().kotlin

    suspend fun webhookById(id: Snowflake) = java.getWebhookById(id).awaitSingle()

    suspend fun webhookbyIdWithToken(id: Snowflake, token: String) =
        java.getWebhookByIdWithToken(id, token).awaitSingle()

    suspend fun applicationInfo() = java.applicationInfo.awaitSingle()

    val users = java.users.asFlow()
    val regions = java.regions.asFlow()

    suspend fun templateByCode(templateCode: String) =
        java.getTemplateByCode(templateCode).awaitSingle()

    // TODO: Create Kotlin-style builder for GuildCreateSpec and appropriate proxy method
    suspend fun createGuild(spec: GuildCreateSpec) = java.createGuild(spec).awaitSingle()

    suspend fun updatePresence(clientPresence: ClientPresence) {
        java.updatePresence(clientPresence).awaitSingle()
    }

    suspend fun updatePresence(clientPresence: ClientPresence, shardId: Int) {
        java.updatePresence(clientPresence, shardId).awaitSingle()
    }

    // TODO: Create Kotlin-style builder for UserEditSpec and appropriate proxy method
    suspend fun edit(spec: UserEditSpec) = java.edit(spec).awaitSingle()

    suspend fun logout() = java.logout().awaitSingle()

    fun <E : Event> on(eventClass: KClass<E>) = java.on(eventClass.java).asFlow()

    suspend fun <E : Event, T> on(eventClass: KClass<E>, mapper: suspend (E) -> T?) =
        java.on(eventClass.java) {
            mono {
                mapper(it)
            }
        }

    suspend fun <E : Event, T> on(
        eventClass: KClass<E>, mapper: suspend (E, SendChannel<T>) -> Unit
    ) = java.on(eventClass.java) {
        publish {
            mapper(it, this)
        }
    }

    // TODO: Create Kotlin wrapper for ReactiveEventAdapter that uses suspend functions and flows instead of mono/flux
    fun on(adapter: ReactiveEventAdapter) = java.on(adapter).asFlow()

    fun requestMembers(guildId: Snowflake) = java.requestMembers(guildId).asFlow()

    fun requestMembers(guildId: Snowflake, userIds: Set<Snowflake>) = java.requestMembers(guildId, userIds).asFlow()

    // TODO: Create Kotlin-style builder for RequestGuildMembers and appropriate proxy method
    fun requestMembers(request: RequestGuildMembers) = java.requestMembers(request).asFlow()

    fun requestMemberChunks(request: RequestGuildMembers) = java.requestMemberChunks(request).asFlow()

    fun withRetrievalStrategy(strategy: EntityRetrievalStrategy): EntityRetrieverKt =
        wrap(java.withRetrievalStrategy(strategy) as GatewayDiscordClient)

    companion object {
        fun wrap(java: GatewayDiscordClient) = GatewayDiscordClientKt(java)
    }
}
