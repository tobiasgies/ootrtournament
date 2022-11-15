package de.tobiasgies.ootrtournament.web

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.web.server.ServerHttpSecurity
import org.springframework.security.config.web.server.invoke
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService
import org.springframework.security.core.userdetails.ReactiveUserDetailsService
import org.springframework.security.core.userdetails.User

@Configuration
class SecurityConfig {
    @Bean
    fun springSecurityFilterChain(http: ServerHttpSecurity) = http {
        authorizeExchange {
            authorize("/", permitAll)
            authorize("/tournaments/**", permitAll)
            authorize("/my/**", authenticated)
            authorize(anyExchange, denyAll)
        }
        formLogin {  }
    }

    @Bean
    fun dummyUers(): ReactiveUserDetailsService {
        val users = User.withDefaultPasswordEncoder()
        val user = users
            .username("user")
            .password("user")
            .roles("USER")
            .build()
        val admin = users
            .username("admin")
            .password("admin")
            .roles("USER", "ADMIN")
            .build()
        return MapReactiveUserDetailsService(user, admin)
    }
}