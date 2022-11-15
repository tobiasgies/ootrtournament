package de.tobiasgies.ootrtournament.discord

import de.tobiasgies.ootrtournament.entities.Tournament
import discord4j.core.`object`.component.ActionRow
import discord4j.core.`object`.component.Button
import discord4j.core.`object`.component.SelectMenu
import discord4j.core.`object`.component.TextInput
import discord4j.core.`object`.entity.channel.MessageChannel
import discord4j.core.spec.MessageCreateMono
import java.util.*

class DiscordTournamentSignupFlow {
    fun buildSignupMessage(tournament: Tournament, messageChannel: MessageChannel) {
        MessageCreateMono.of(messageChannel).withContent(
            "Thanks for signing up for **${tournament.name}**! " +
                    "Please let us know a few more pieces of information and then you're good to go!"
        ).withComponents(
            ActionRow.of(
                TextInput.small(
                    "racetime_profile",
                    "Your racetime.gg profile URL",
                    "https://racetime.gg/user/AR4nd0mB1tOfT3xt"
                )
            ),
            ActionRow.of(
                TextInput.small(
                    "pronouns",
                    "Your preferred pronouns",
                    "they/them"
                )
            ),
            ActionRow.of(
                SelectMenu.of("country", ISO_COUNTRIES.map {
                    SelectMenu.Option.of(it.value, it.key)
                })
            ),
            ActionRow.of(
                Button.primary("rules_consent", "I agree to the rules and Fair Play Agreement"),
                Button.secondary("rules_reject", "I do not agree")
            ),
            ActionRow.of(
                Button.success("submit", "Submit")
            )
        )
    }

    companion object {
        private val ISO_COUNTRIES = Locale.getISOCountries().associateWith {
            Locale("", it).getDisplayCountry(Locale.ENGLISH)
        }
    }
}