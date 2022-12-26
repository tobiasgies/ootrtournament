package de.tobiasgies.discord4k.core.event

import discord4j.core.event.ReactiveEventAdapter
import discord4j.core.event.domain.*
import discord4j.core.event.domain.channel.*
import discord4j.core.event.domain.command.ApplicationCommandCreateEvent
import discord4j.core.event.domain.command.ApplicationCommandDeleteEvent
import discord4j.core.event.domain.command.ApplicationCommandUpdateEvent
import discord4j.core.event.domain.guild.*
import discord4j.core.event.domain.integration.IntegrationCreateEvent
import discord4j.core.event.domain.integration.IntegrationDeleteEvent
import discord4j.core.event.domain.integration.IntegrationUpdateEvent
import discord4j.core.event.domain.interaction.*
import discord4j.core.event.domain.lifecycle.*
import discord4j.core.event.domain.message.*
import discord4j.core.event.domain.role.RoleCreateEvent
import discord4j.core.event.domain.role.RoleDeleteEvent
import discord4j.core.event.domain.role.RoleUpdateEvent
import kotlinx.coroutines.channels.SendChannel
import kotlinx.coroutines.reactive.publish

abstract class ReactiveEventAdapterKt : ReactiveEventAdapter() {
    final override fun onReady(event: ReadyEvent) = publish {
        handleReady(event)?.also { send(it) }
        handleReady(event, this)
    }

    open suspend fun handleReady(event: ReadyEvent): Any? = null
    open suspend fun handleReady(event: ReadyEvent, channel: SendChannel<*>) {}

    final override fun onResume(event: ResumeEvent) = publish {
        handleResume(event)?.also { send(it) }
        handleResume(event, this)
    }

    open suspend fun handleResume(event: ResumeEvent): Any? = null
    open suspend fun handleResume(event: ResumeEvent, channel: SendChannel<*>) {}
    
    final override fun onMessageCreate(event: MessageCreateEvent) = publish {
        handleMessageCreate(event)?.also { send(it) }
        handleMessageCreate(event, this)
    }

    open suspend fun handleMessageCreate(event: MessageCreateEvent): Any? = null
    open suspend fun handleMessageCreate(event: MessageCreateEvent, channel: SendChannel<*>) {}

    final override fun onMessageDelete(event: MessageDeleteEvent) = publish {
        handleMessageDelete(event)?.also { send(it) }
        handleMessageDelete(event, this)
    }

    open suspend fun handleMessageDelete(event: MessageDeleteEvent): Any? = null
    open suspend fun handleMessageDelete(event: MessageDeleteEvent, channel: SendChannel<*>) {}
    
    final override fun onMessageUpdate(event: MessageUpdateEvent) = publish {
        handleMessageUpdate(event)?.also { send(it) }
        handleMessageUpdate(event, this)
    }

    open suspend fun handleMessageUpdate(event: MessageUpdateEvent): Any? = null
    open suspend fun handleMessageUpdate(event: MessageUpdateEvent, channel: SendChannel<*>) {}
    
    final override fun onMessageBulkDelete(event: MessageBulkDeleteEvent) = publish {
        handleMessageBulkDelete(event)?.also { send(it) }
        handleMessageBulkDelete(event, this)
    }

    open suspend fun handleMessageBulkDelete(event: MessageBulkDeleteEvent): Any? = null
    open suspend fun handleMessageBulkDelete(event: MessageBulkDeleteEvent, channel: SendChannel<*>) {}

    final override fun onReactionAdd(event: ReactionAddEvent) = publish {
        handleReactionAdd(event)?.also { send(it) }
        handleReactionAdd(event, this)
    }

    open suspend fun handleReactionAdd(event: ReactionAddEvent): Any? = null
    open suspend fun handleReactionAdd(event: ReactionAddEvent, channel: SendChannel<*>) {}

    final override fun onReactionRemove(event: ReactionRemoveEvent) = publish {
        handleReactionRemove(event)?.also { send(it) }
        handleReactionRemove(event, this)
    }

    open suspend fun handleReactionRemove(event: ReactionRemoveEvent): Any? = null
    open suspend fun handleReactionRemove(event: ReactionRemoveEvent, channel: SendChannel<*>) {}

    final override fun onReactionRemoveEmoji(event: ReactionRemoveEmojiEvent) = publish {
        handleReactionRemoveEmoji(event)?.also { send(it) }
        handleReactionRemoveEmoji(event, this)
    }

    open suspend fun handleReactionRemoveEmoji(event: ReactionRemoveEmojiEvent): Any? = null
    open suspend fun handleReactionRemoveEmoji(event: ReactionRemoveEmojiEvent, channel: SendChannel<*>) {}

    final override fun onReactionRemoveAll(event: ReactionRemoveAllEvent) = publish {
        handleReactionRemoveAll(event)?.also { send(it) }
        handleReactionRemoveAll(event, this)
    }

    open suspend fun handleReactionRemoveAll(event: ReactionRemoveAllEvent): Any? = null
    open suspend fun handleReactionRemoveAll(event: ReactionRemoveAllEvent, channel: SendChannel<*>) {}

    final override fun onApplicationCommandCreate(event: ApplicationCommandCreateEvent) = publish {
        handleApplicationCommandCreate(event)?.also { send(it) }
        handleApplicationCommandCreate(event, this)
    }

    open suspend fun handleApplicationCommandCreate(event: ApplicationCommandCreateEvent): Any? = null
    open suspend fun handleApplicationCommandCreate(event: ApplicationCommandCreateEvent, channel: SendChannel<*>) {}

    final override fun onApplicationCommandUpdate(event: ApplicationCommandUpdateEvent) = publish {
        handleApplicationCommandUpdate(event)?.also { send(it) }
        handleApplicationCommandUpdate(event, this)
    }

    open suspend fun handleApplicationCommandUpdate(event: ApplicationCommandUpdateEvent): Any? = null
    open suspend fun handleApplicationCommandUpdate(event: ApplicationCommandUpdateEvent, channel: SendChannel<*>) {}

    final override fun onApplicationCommandDelete(event: ApplicationCommandDeleteEvent) = publish {
        handleApplicationCommandDelete(event)?.also { send(it) }
        handleApplicationCommandDelete(event, this)
    }

    open suspend fun handleApplicationCommandDelete(event: ApplicationCommandDeleteEvent): Any? = null
    open suspend fun handleApplicationCommandDelete(event: ApplicationCommandDeleteEvent, channel: SendChannel<*>) {}

    final override fun onGuildCreate(event: GuildCreateEvent) = publish {
        handleGuildCreate(event)?.also { send(it) }
        handleGuildCreate(event, this)
    }

    open suspend fun handleGuildCreate(event: GuildCreateEvent): Any? = null
    open suspend fun handleGuildCreate(event: GuildCreateEvent, channel: SendChannel<*>) {}

    final override fun onGuildUpdate(event: GuildUpdateEvent) = publish {
        handleGuildUpdate(event)?.also { send(it) }
        handleGuildUpdate(event, this)
    }

    open suspend fun handleGuildUpdate(event: GuildUpdateEvent): Any? = null
    open suspend fun handleGuildUpdate(event: GuildUpdateEvent, channel: SendChannel<*>) {}

    final override fun onGuildDelete(event: GuildDeleteEvent) = publish {
        handleGuildDelete(event)?.also { send(it) }
        handleGuildDelete(event, this)
    }

    open suspend fun handleGuildDelete(event: GuildDeleteEvent): Any? = null
    open suspend fun handleGuildDelete(event: GuildDeleteEvent, channel: SendChannel<*>) {}

    final override fun onMemberJoin(event: MemberJoinEvent) = publish {
        handleMemberJoin(event)?.also { send(it) }
        handleMemberJoin(event, this)
    }

    open suspend fun handleMemberJoin(event: MemberJoinEvent): Any? = null
    open suspend fun handleMemberJoin(event: MemberJoinEvent, channel: SendChannel<*>) {}

    final override fun onMemberUpdate(event: MemberUpdateEvent) = publish {
        handleMemberUpdate(event)?.also { send(it) }
        handleMemberUpdate(event, this)
    }

    open suspend fun handleMemberUpdate(event: MemberUpdateEvent): Any? = null
    open suspend fun handleMemberUpdate(event: MemberUpdateEvent, channel: SendChannel<*>) {}

    final override fun onMemberLeave(event: MemberLeaveEvent) = publish {
        handleMemberLeave(event)?.also { send(it) }
        handleMemberLeave(event, this)
    }

    open suspend fun handleMemberLeave(event: MemberLeaveEvent): Any? = null
    open suspend fun handleMemberLeave(event: MemberLeaveEvent, channel: SendChannel<*>) {}

    final override fun onMemberChunk(event: MemberChunkEvent) = publish {
        handleMemberChunk(event)?.also { send(it) }
        handleMemberChunk(event, this)
    }

    open suspend fun handleMemberChunk(event: MemberChunkEvent): Any? = null
    open suspend fun handleMemberChunk(event: MemberChunkEvent, channel: SendChannel<*>) {}

    final override fun onEmojisUpdate(event: EmojisUpdateEvent) = publish {
        handleEmojisUpdate(event)?.also { send(it) }
        handleEmojisUpdate(event, this)
    }

    open suspend fun handleEmojisUpdate(event: EmojisUpdateEvent): Any? = null
    open suspend fun handleEmojisUpdate(event: EmojisUpdateEvent, channel: SendChannel<*>) {}

    final override fun onStickersUpdate(event: StickersUpdateEvent) = publish {
        handleStickersUpdate(event)?.also { send(it) }
        handleStickersUpdate(event, this)
    }

    open suspend fun handleStickersUpdate(event: StickersUpdateEvent): Any? = null
    open suspend fun handleStickersUpdate(event: StickersUpdateEvent, channel: SendChannel<*>) {}

    final override fun onBan(event: BanEvent) = publish {
        handleBan(event)?.also { send(it) }
        handleBan(event, this)
    }

    open suspend fun handleBan(event: BanEvent): Any? = null
    open suspend fun handleBan(event: BanEvent, channel: SendChannel<*>) {}

    final override fun onUnban(event: UnbanEvent) = publish {
        handleUnban(event)?.also { send(it) }
        handleUnban(event, this)
    }

    open suspend fun handleUnban(event: UnbanEvent): Any? = null
    open suspend fun handleUnban(event: UnbanEvent, channel: SendChannel<*>) {}

    final override fun onIntegrationsUpdate(event: IntegrationsUpdateEvent) = publish {
        handleIntegrationsUpdate(event)?.also { send(it) }
        handleIntegrationsUpdate(event, this)
    }

    open suspend fun handleIntegrationsUpdate(event: IntegrationsUpdateEvent): Any? = null
    open suspend fun handleIntegrationsUpdate(event: IntegrationsUpdateEvent, channel: SendChannel<*>) {}

    final override fun onWebhooksUpdate(event: WebhooksUpdateEvent) = publish {
        handleWebhooksUpdate(event)?.also { send(it) }
        handleWebhooksUpdate(event, this)
    }

    open suspend fun handleWebhooksUpdate(event: WebhooksUpdateEvent): Any? = null
    open suspend fun handleWebhooksUpdate(event: WebhooksUpdateEvent, channel: SendChannel<*>) {}

    final override fun onTextChannelCreate(event: TextChannelCreateEvent) = publish {
        handleTextChannelCreate(event)?.also { send(it) }
        handleTextChannelCreate(event, this)
    }

    open suspend fun handleTextChannelCreate(event: TextChannelCreateEvent): Any? = null
    open suspend fun handleTextChannelCreate(event: TextChannelCreateEvent, channel: SendChannel<*>) {}

    final override fun onTextChannelDelete(event: TextChannelDeleteEvent) = publish {
        handleTextChannelDelete(event)?.also { send(it) }
        handleTextChannelDelete(event, this)
    }

    open suspend fun handleTextChannelDelete(event: TextChannelDeleteEvent): Any? = null
    open suspend fun handleTextChannelDelete(event: TextChannelDeleteEvent, channel: SendChannel<*>) {}

    final override fun onTextChannelUpdate(event: TextChannelUpdateEvent) = publish {
        handleTextChannelUpdate(event)?.also { send(it) }
        handleTextChannelUpdate(event, this)
    }

    open suspend fun handleTextChannelUpdate(event: TextChannelUpdateEvent): Any? = null
    open suspend fun handleTextChannelUpdate(event: TextChannelUpdateEvent, channel: SendChannel<*>) {}

    final override fun onVoiceChannelCreate(event: VoiceChannelCreateEvent) = publish {
        handleVoiceChannelCreate(event)?.also { send(it) }
        handleVoiceChannelCreate(event, this)
    }

    open suspend fun handleVoiceChannelCreate(event: VoiceChannelCreateEvent): Any? = null
    open suspend fun handleVoiceChannelCreate(event: VoiceChannelCreateEvent, channel: SendChannel<*>) {}

    final override fun onVoiceChannelDelete(event: VoiceChannelDeleteEvent) = publish {
        handleVoiceChannelDelete(event)?.also { send(it) }
        handleVoiceChannelDelete(event, this)
    }

    open suspend fun handleVoiceChannelDelete(event: VoiceChannelDeleteEvent): Any? = null
    open suspend fun handleVoiceChannelDelete(event: VoiceChannelDeleteEvent, channel: SendChannel<*>) {}

    final override fun onVoiceChannelUpdate(event: VoiceChannelUpdateEvent) = publish {
        handleVoiceChannelUpdate(event)?.also { send(it) }
        handleVoiceChannelUpdate(event, this)
    }

    open suspend fun handleVoiceChannelUpdate(event: VoiceChannelUpdateEvent): Any? = null
    open suspend fun handleVoiceChannelUpdate(event: VoiceChannelUpdateEvent, channel: SendChannel<*>) {}

    final override fun onCategoryCreate(event: CategoryCreateEvent) = publish {
        handleCategoryCreate(event)?.also { send(it) }
        handleCategoryCreate(event, this)
    }

    open suspend fun handleCategoryCreate(event: CategoryCreateEvent): Any? = null
    open suspend fun handleCategoryCreate(event: CategoryCreateEvent, channel: SendChannel<*>) {}

    final override fun onCategoryDelete(event: CategoryDeleteEvent) = publish {
        handleCategoryDelete(event)?.also { send(it) }
        handleCategoryDelete(event, this)
    }

    open suspend fun handleCategoryDelete(event: CategoryDeleteEvent): Any? = null
    open suspend fun handleCategoryDelete(event: CategoryDeleteEvent, channel: SendChannel<*>) {}

    final override fun onCategoryUpdate(event: CategoryUpdateEvent) = publish {
        handleCategoryUpdate(event)?.also { send(it) }
        handleCategoryUpdate(event, this)
    }

    open suspend fun handleCategoryUpdate(event: CategoryUpdateEvent): Any? = null
    open suspend fun handleCategoryUpdate(event: CategoryUpdateEvent, channel: SendChannel<*>) {}

    final override fun onNewsChannelCreate(event: NewsChannelCreateEvent) = publish {
        handleNewsChannelCreate(event)?.also { send(it) }
        handleNewsChannelCreate(event, this)
    }

    open suspend fun handleNewsChannelCreate(event: NewsChannelCreateEvent): Any? = null
    open suspend fun handleNewsChannelCreate(event: NewsChannelCreateEvent, channel: SendChannel<*>) {}

    final override fun onNewsChannelDelete(event: NewsChannelDeleteEvent) = publish {
        handleNewsChannelDelete(event)?.also { send(it) }
        handleNewsChannelDelete(event, this)
    }

    open suspend fun handleNewsChannelDelete(event: NewsChannelDeleteEvent): Any? = null
    open suspend fun handleNewsChannelDelete(event: NewsChannelDeleteEvent, channel: SendChannel<*>) {}

    final override fun onNewsChannelUpdate(event: NewsChannelUpdateEvent) = publish {
        handleNewsChannelUpdate(event)?.also { send(it) }
        handleNewsChannelUpdate(event, this)
    }

    open suspend fun handleNewsChannelUpdate(event: NewsChannelUpdateEvent): Any? = null
    open suspend fun handleNewsChannelUpdate(event: NewsChannelUpdateEvent, channel: SendChannel<*>) {}

    final override fun onStoreChannelCreate(event: StoreChannelCreateEvent) = publish {
        handleStoreChannelCreate(event)?.also { send(it) }
        handleStoreChannelCreate(event, this)
    }

    open suspend fun handleStoreChannelCreate(event: StoreChannelCreateEvent): Any? = null
    open suspend fun handleStoreChannelCreate(event: StoreChannelCreateEvent, channel: SendChannel<*>) {}

    final override fun onStoreChannelDelete(event: StoreChannelDeleteEvent) = publish {
        handleStoreChannelDelete(event)?.also { send(it) }
        handleStoreChannelDelete(event, this)
    }

    open suspend fun handleStoreChannelDelete(event: StoreChannelDeleteEvent): Any? = null
    open suspend fun handleStoreChannelDelete(event: StoreChannelDeleteEvent, channel: SendChannel<*>) {}

    final override fun onStoreChannelUpdate(event: StoreChannelUpdateEvent) = publish {
        handleStoreChannelUpdate(event)?.also { send(it) }
        handleStoreChannelUpdate(event, this)
    }

    open suspend fun handleStoreChannelUpdate(event: StoreChannelUpdateEvent): Any? = null
    open suspend fun handleStoreChannelUpdate(event: StoreChannelUpdateEvent, channel: SendChannel<*>) {}

    final override fun onUnknownChannelCreate(event: UnknownChannelCreateEvent) = publish {
        handleUnknownChannelCreate(event)?.also { send(it) }
        handleUnknownChannelCreate(event, this)
    }

    open suspend fun handleUnknownChannelCreate(event: UnknownChannelCreateEvent): Any? = null
    open suspend fun handleUnknownChannelCreate(event: UnknownChannelCreateEvent, channel: SendChannel<*>) {}

    final override fun onUnknownChannelDelete(event: UnknownChannelDeleteEvent) = publish {
        handleUnknownChannelDelete(event)?.also { send(it) }
        handleUnknownChannelDelete(event, this)
    }

    open suspend fun handleUnknownChannelDelete(event: UnknownChannelDeleteEvent): Any? = null
    open suspend fun handleUnknownChannelDelete(event: UnknownChannelDeleteEvent, channel: SendChannel<*>) {}

    final override fun onUnknownChannelUpdate(event: UnknownChannelUpdateEvent) = publish {
        handleUnknownChannelUpdate(event)?.also { send(it) }
        handleUnknownChannelUpdate(event, this)
    }

    open suspend fun handleUnknownChannelUpdate(event: UnknownChannelUpdateEvent): Any? = null
    open suspend fun handleUnknownChannelUpdate(event: UnknownChannelUpdateEvent, channel: SendChannel<*>) {}

    final override fun onTypingStart(event: TypingStartEvent) = publish {
        handleTypingStart(event)?.also { send(it) }
        handleTypingStart(event, this)
    }

    open suspend fun handleTypingStart(event: TypingStartEvent): Any? = null
    open suspend fun handleTypingStart(event: TypingStartEvent, channel: SendChannel<*>) {}

    final override fun onPinsUpdate(event: PinsUpdateEvent) = publish {
        handlePinsUpdate(event)?.also { send(it) }
        handlePinsUpdate(event, this)
    }

    open suspend fun handlePinsUpdate(event: PinsUpdateEvent): Any? = null
    open suspend fun handlePinsUpdate(event: PinsUpdateEvent, channel: SendChannel<*>) {}

    final override fun onRoleCreate(event: RoleCreateEvent) = publish {
        handleRoleCreate(event)?.also { send(it) }
        handleRoleCreate(event, this)
    }

    open suspend fun handleRoleCreate(event: RoleCreateEvent): Any? = null
    open suspend fun handleRoleCreate(event: RoleCreateEvent, channel: SendChannel<*>) {}

    final override fun onRoleDelete(event: RoleDeleteEvent) = publish {
        handleRoleDelete(event)?.also { send(it) }
        handleRoleDelete(event, this)
    }

    open suspend fun handleRoleDelete(event: RoleDeleteEvent): Any? = null
    open suspend fun handleRoleDelete(event: RoleDeleteEvent, channel: SendChannel<*>) {}

    final override fun onRoleUpdate(event: RoleUpdateEvent) = publish {
        handleRoleUpdate(event)?.also { send(it) }
        handleRoleUpdate(event, this)
    }

    open suspend fun handleRoleUpdate(event: RoleUpdateEvent): Any? = null
    open suspend fun handleRoleUpdate(event: RoleUpdateEvent, channel: SendChannel<*>) {}

    final override fun onInviteCreate(event: InviteCreateEvent) = publish {
        handleInviteCreate(event)?.also { send(it) }
        handleInviteCreate(event, this)
    }

    open suspend fun handleInviteCreate(event: InviteCreateEvent): Any? = null
    open suspend fun handleInviteCreate(event: InviteCreateEvent, channel: SendChannel<*>) {}

    final override fun onInviteDelete(event: InviteDeleteEvent) = publish {
        handleInviteDelete(event)?.also { send(it) }
        handleInviteDelete(event, this)
    }

    open suspend fun handleInviteDelete(event: InviteDeleteEvent): Any? = null
    open suspend fun handleInviteDelete(event: InviteDeleteEvent, channel: SendChannel<*>) {}

    final override fun onUserUpdate(event: UserUpdateEvent) = publish {
        handleUserUpdate(event)?.also { send(it) }
        handleUserUpdate(event, this)
    }

    open suspend fun handleUserUpdate(event: UserUpdateEvent): Any? = null
    open suspend fun handleUserUpdate(event: UserUpdateEvent, channel: SendChannel<*>) {}

    final override fun onPresenceUpdate(event: PresenceUpdateEvent) = publish {
        handlePresenceUpdate(event)?.also { send(it) }
        handlePresenceUpdate(event, this)
    }

    open suspend fun handlePresenceUpdate(event: PresenceUpdateEvent): Any? = null
    open suspend fun handlePresenceUpdate(event: PresenceUpdateEvent, channel: SendChannel<*>) {}

    final override fun onVoiceStateUpdate(event: VoiceStateUpdateEvent) = publish {
        handleVoiceStateUpdate(event)?.also { send(it) }
        handleVoiceStateUpdate(event, this)
    }

    open suspend fun handleVoiceStateUpdate(event: VoiceStateUpdateEvent): Any? = null
    open suspend fun handleVoiceStateUpdate(event: VoiceStateUpdateEvent, channel: SendChannel<*>) {}

    final override fun onVoiceServerUpdate(event: VoiceServerUpdateEvent) = publish {
        handleVoiceServerUpdate(event)?.also { send(it) }
        handleVoiceServerUpdate(event, this)
    }

    open suspend fun handleVoiceServerUpdate(event: VoiceServerUpdateEvent): Any? = null
    open suspend fun handleVoiceServerUpdate(event: VoiceServerUpdateEvent, channel: SendChannel<*>) {}

    final override fun onConnect(event: ConnectEvent) = publish {
        handleConnect(event)?.also { send(it) }
        handleConnect(event, this)
    }

    open suspend fun handleConnect(event: ConnectEvent): Any? = null
    open suspend fun handleConnect(event: ConnectEvent, channel: SendChannel<*>) {}

    final override fun onReconnect(event: ReconnectEvent) = publish {
        handleReconnect(event)?.also { send(it) }
        handleReconnect(event, this)
    }

    open suspend fun handleReconnect(event: ReconnectEvent): Any? = null
    open suspend fun handleReconnect(event: ReconnectEvent, channel: SendChannel<*>) {}

    final override fun onDisconnect(event: DisconnectEvent) = publish {
        handleDisconnect(event)?.also { send(it) }
        handleDisconnect(event, this)
    }

    open suspend fun handleDisconnect(event: DisconnectEvent): Any? = null
    open suspend fun handleDisconnect(event: DisconnectEvent, channel: SendChannel<*>) {}

    final override fun onReconnectStart(event: ReconnectStartEvent) = publish {
        handleReconnectStart(event)?.also { send(it) }
        handleReconnectStart(event, this)
    }

    open suspend fun handleReconnectStart(event: ReconnectStartEvent): Any? = null
    open suspend fun handleReconnectStart(event: ReconnectStartEvent, channel: SendChannel<*>) {}

    final override fun onReconnectFail(event: ReconnectFailEvent) = publish {
        handleReconnectFail(event)?.also { send(it) }
        handleReconnectFail(event, this)
    }

    open suspend fun handleReconnectFail(event: ReconnectFailEvent): Any? = null
    open suspend fun handleReconnectFail(event: ReconnectFailEvent, channel: SendChannel<*>) {}

    final override fun onSessionInvalidated(event: SessionInvalidatedEvent) = publish {
        handleSessionInvalidated(event)?.also { send(it) }
        handleSessionInvalidated(event, this)
    }

    open suspend fun handleSessionInvalidated(event: SessionInvalidatedEvent): Any? = null
    open suspend fun handleSessionInvalidated(event: SessionInvalidatedEvent, channel: SendChannel<*>) {}

    final override fun onInteractionCreate(event: InteractionCreateEvent) = publish {
        handleInteractionCreate(event)?.also { send(it) }
        handleInteractionCreate(event, this)
    }

    open suspend fun handleInteractionCreate(event: InteractionCreateEvent): Any? = null
    open suspend fun handleInteractionCreate(event: InteractionCreateEvent, channel: SendChannel<*>) {}

    final override fun onDeferrableInteraction(event: DeferrableInteractionEvent) = publish {
        handleDeferrableInteraction(event)?.also { send(it) }
        handleDeferrableInteraction(event, this)
    }

    open suspend fun handleDeferrableInteraction(event: DeferrableInteractionEvent): Any? = null
    open suspend fun handleDeferrableInteraction(event: DeferrableInteractionEvent, channel: SendChannel<*>) {}

    final override fun onApplicationCommandInteraction(event: ApplicationCommandInteractionEvent) = publish {
        handleApplicationCommandInteraction(event)?.also { send(it) }
        handleApplicationCommandInteraction(event, this)
    }

    open suspend fun handleApplicationCommandInteraction(event: ApplicationCommandInteractionEvent): Any? = null
    open suspend fun handleApplicationCommandInteraction(event: ApplicationCommandInteractionEvent, channel: SendChannel<*>) {}

    final override fun onChatInputInteraction(event: ChatInputInteractionEvent) = publish {
        handleChatInputInteraction(event)?.also { send(it) }
        handleChatInputInteraction(event, this)
    }

    open suspend fun handleChatInputInteraction(event: ChatInputInteractionEvent): Any? = null
    open suspend fun handleChatInputInteraction(event: ChatInputInteractionEvent, channel: SendChannel<*>) {}

    final override fun onMessageInteraction(event: MessageInteractionEvent) = publish {
        handleMessageInteraction(event)?.also { send(it) }
        handleMessageInteraction(event, this)
    }

    open suspend fun handleMessageInteraction(event: MessageInteractionEvent): Any? = null
    open suspend fun handleMessageInteraction(event: MessageInteractionEvent, channel: SendChannel<*>) {}

    final override fun onUserInteraction(event: UserInteractionEvent) = publish {
        handleUserInteraction(event)?.also { send(it) }
        handleUserInteraction(event, this)
    }

    open suspend fun handleUserInteraction(event: UserInteractionEvent): Any? = null
    open suspend fun handleUserInteraction(event: UserInteractionEvent, channel: SendChannel<*>) {}

    final override fun onComponentInteraction(event: ComponentInteractionEvent) = publish {
        handleComponentInteraction(event)?.also { send(it) }
        handleComponentInteraction(event, this)
    }

    open suspend fun handleComponentInteraction(event: ComponentInteractionEvent): Any? = null
    open suspend fun handleComponentInteraction(event: ComponentInteractionEvent, channel: SendChannel<*>) {}

    final override fun onButtonInteraction(event: ButtonInteractionEvent) = publish {
        handleButtonInteraction(event)?.also { send(it) }
        handleButtonInteraction(event, this)
    }

    open suspend fun handleButtonInteraction(event: ButtonInteractionEvent): Any? = null
    open suspend fun handleButtonInteraction(event: ButtonInteractionEvent, channel: SendChannel<*>) {}

    final override fun onSelectMenuInteraction(event: SelectMenuInteractionEvent) = publish {
        handleSelectMenuInteraction(event)?.also { send(it) }
        handleSelectMenuInteraction(event, this)
    }

    open suspend fun handleSelectMenuInteraction(event: SelectMenuInteractionEvent): Any? = null
    open suspend fun handleSelectMenuInteraction(event: SelectMenuInteractionEvent, channel: SendChannel<*>) {}

    final override fun onAutoCompleteInteraction(event: AutoCompleteInteractionEvent) = publish {
        handleAutoCompleteInteraction(event)?.also { send(it) }
        handleAutoCompleteInteraction(event, this)
    }

    open suspend fun handleAutoCompleteInteraction(event: AutoCompleteInteractionEvent): Any? = null
    open suspend fun handleAutoCompleteInteraction(event: AutoCompleteInteractionEvent, channel: SendChannel<*>) {}

    final override fun onChatInputAutoCompleteInteraction(event: ChatInputAutoCompleteEvent) = publish {
        handleChatInputAutoCompleteInteraction(event)?.also { send(it) }
        handleChatInputAutoCompleteInteraction(event, this)
    }

    open suspend fun handleChatInputAutoCompleteInteraction(event: ChatInputAutoCompleteEvent): Any? = null
    open suspend fun handleChatInputAutoCompleteInteraction(event: ChatInputAutoCompleteEvent, channel: SendChannel<*>) {}
    
    final override fun onModalSubmitInteraction(event: ModalSubmitInteractionEvent) = publish {
        handleModalSubmitInteraction(event)?.also { send(it) }
        handleModalSubmitInteraction(event, this)
    }

    open suspend fun handleModalSubmitInteraction(event: ModalSubmitInteractionEvent): Any? = null
    open suspend fun handleModalSubmitInteraction(event: ModalSubmitInteractionEvent, channel: SendChannel<*>) {}

    final override fun onIntegrationCreate(event: IntegrationCreateEvent) = publish {
        handleIntegrationCreate(event)?.also { send(it) }
        handleIntegrationCreate(event, this)
    }

    open suspend fun handleIntegrationCreate(event: IntegrationCreateEvent): Any? = null
    open suspend fun handleIntegrationCreate(event: IntegrationCreateEvent, channel: SendChannel<*>) {}

    final override fun onIntegrationDelete(event: IntegrationDeleteEvent) = publish {
        handleIntegrationDelete(event)?.also { send(it) }
        handleIntegrationDelete(event, this)
    }

    open suspend fun handleIntegrationDelete(event: IntegrationDeleteEvent): Any? = null
    open suspend fun handleIntegrationDelete(event: IntegrationDeleteEvent, channel: SendChannel<*>) {}

    final override fun onIntegrationUpdate(event: IntegrationUpdateEvent) = publish {
        handleIntegrationUpdate(event)?.also { send(it) }
        handleIntegrationUpdate(event, this)
    }

    open suspend fun handleIntegrationUpdate(event: IntegrationUpdateEvent): Any? = null
    open suspend fun handleIntegrationUpdate(event: IntegrationUpdateEvent, channel: SendChannel<*>) {}
}