package de.tobiasgies.ootrtournament.web

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class MyTournamentsController {
    @RequestMapping("/my/tournaments")
    suspend fun myTournaments() = "mytournaments"
}