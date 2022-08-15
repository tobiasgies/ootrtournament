package de.tobiasgies.ootrtournament

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class HomepageController {
    @RequestMapping("/")
    suspend fun index() = "index"
}