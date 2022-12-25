package de.tobiasgies.ootrtournament.discord

import de.tobiasgies.ootrtournament.entities.Tournament
import discord4j.core.`object`.component.ActionRow
import discord4j.core.`object`.component.Button
import discord4j.core.`object`.component.SelectMenu
import discord4j.core.`object`.component.TextInput
import discord4j.core.`object`.entity.channel.MessageChannel
import discord4j.core.spec.MessageCreateMono
import discord4j.discordjson.json.MessageCreateRequest
import org.springframework.stereotype.Component
import java.util.*

@Component
class DiscordTournamentSignupFlow {
    fun buildSignupMessage(tournament: Tournament): MessageCreateRequest {
        return MessageCreateRequest.builder().content(
            "Thanks for signing up for **${tournament.name}**! " +
                    "Please let us know a few more pieces of information and then you're good to go!"
        ).addComponent(
            ActionRow.of(
                Button.primary("rules_consent", "I agree to the rules and Fair Play Agreement"),
                Button.secondary("rules_reject", "I do not agree")
            ).data
        ).addComponent(
            ActionRow.of(
                Button.success("submit", "Submit")
            ).data
        ).build()
    }

    companion object {
        private val ISO_COUNTRIES = Locale.getISOCountries().associateWith {
            Locale("", it).getDisplayCountry(Locale.ENGLISH)
        }
    }
}