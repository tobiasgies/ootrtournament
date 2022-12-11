package de.tobiasgies.ootrtournament.web

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity
import org.springframework.security.config.web.server.ServerHttpSecurity
import org.springframework.security.config.web.server.ServerHttpSecurity.CsrfSpec
import org.springframework.security.config.web.server.invoke
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService
import org.springframework.security.core.userdetails.ReactiveUserDetailsService
import org.springframework.security.core.userdetails.User
import org.springframework.security.web.server.SecurityWebFilterChain
import org.springframework.security.web.server.csrf.CsrfWebFilter
import org.springframework.security.web.server.util.matcher.AndServerWebExchangeMatcher
import org.springframework.security.web.server.util.matcher.NegatedServerWebExchangeMatcher
import org.springframework.security.web.server.util.matcher.ServerWebExchangeMatcher
import org.springframework.security.web.server.util.matcher.ServerWebExchangeMatchers


@Configuration
class SecurityConfig {
    @Bean
    fun springSecurityFilterChain(http: ServerHttpSecurity) = http {
        authorizeExchange {
            authorize("/", permitAll)
            authorize("/tournaments/**", permitAll)
            authorize("/discord/**", permitAll)
            authorize("/my/**", authenticated)
            authorize(anyExchange, denyAll)
        }
        csrf {
            // Prevent /discord URLs to be excluded from the CSRF token matcher for now.
            // Should probably generalize that for all REST API URLs.
            requireCsrfProtectionMatcher = AndServerWebExchangeMatcher(
                NegatedServerWebExchangeMatcher(ServerWebExchangeMatchers.pathMatchers("/discord/**")),
                CsrfWebFilter.DEFAULT_CSRF_MATCHER
            )
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