package de.tobiasgies.ootrtournament.web

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/tournaments")
class TournamentsController {
    @RequestMapping(path = ["", "/"])
    suspend fun tournamentList() = "tournaments"

    @RequestMapping("/{tournamentSlug}")
    suspend fun singleTournament(tournamentSlug: String) = "tournament"
}