package de.tobiasgies.discord4k.core.retriever

import discord4j.common.util.Snowflake
import discord4j.core.retriever.EntityRetriever
import kotlinx.coroutines.reactive.asFlow
import kotlinx.coroutines.reactor.awaitSingle

interface EntityRetrieverKt {
    val java: EntityRetriever

    suspend fun channelById(channelId: Snowflake) = java.getChannelById(channelId).awaitSingle()
    suspend fun guildById(guildId: Snowflake) = java.getGuildById(guildId).awaitSingle()
    suspend fun guildStickerById(guildId: Snowflake, stickerId: Snowflake) =
        java.getGuildStickerById(guildId, stickerId).awaitSingle()
    suspend fun guildEmojiById(guildId: Snowflake, emojiId: Snowflake) =
        java.getGuildEmojiById(guildId, emojiId).awaitSingle()
    suspend fun memberById(guildId: Snowflake, userId: Snowflake) =
        java.getMemberById(guildId, userId).awaitSingle()
    suspend fun messageById(guildId: Snowflake, messageId: Snowflake) =
        java.getMessageById(guildId, messageId).awaitSingle()
    suspend fun roleById(guildId: Snowflake, roleId: Snowflake) =
        java.getRoleById(guildId, roleId).awaitSingle()
    suspend fun userById(userId: Snowflake) = java.getUserById(userId).awaitSingle()
    fun guilds() = java.guilds.asFlow()
    suspend fun self() = java.self.awaitSingle()
    suspend fun selfMember(guildId: Snowflake) = java.getSelfMember(guildId).awaitSingle()
    fun guildMembers(guildId: Snowflake) = java.getGuildMembers(guildId).asFlow()
    fun guildChannels(guildId: Snowflake) = java.getGuildChannels(guildId).asFlow()
    fun guildRoles(guildId: Snowflake) = java.getGuildRoles(guildId).asFlow()
    fun guildEmojis(guildId: Snowflake) = java.getGuildEmojis(guildId).asFlow()
    fun guildStickers(guildId: Snowflake) = java.getGuildStickers(guildId).asFlow()
}