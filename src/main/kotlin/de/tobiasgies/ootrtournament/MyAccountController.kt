package de.tobiasgies.ootrtournament

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class MyAccountController {
    @RequestMapping("/my/account")
    suspend fun myAccount() = "myaccount"
}