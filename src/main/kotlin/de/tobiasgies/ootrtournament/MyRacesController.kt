package de.tobiasgies.ootrtournament

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class MyRacesController {
    @RequestMapping("/my/races")
    suspend fun myRaces() = "myraces"
}