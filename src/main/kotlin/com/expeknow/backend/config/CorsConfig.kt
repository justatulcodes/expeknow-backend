package com.expeknow.backend.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.CorsConfigurationSource
import org.springframework.web.cors.UrlBasedCorsConfigurationSource

@Configuration
class CorsConfig {

    @Value("\${app.cors.allowed-origins}")
    private lateinit var allowedOrigins: String

    @Value("\${app.cors.allowed-methods}")
    private lateinit var allowedMethods: String

    @Value("\${app.cors.allowed-headers}")
    private lateinit var allowedHeaders: String

    @Value("\${app.cors.allow-credentials}")
    private var allowCredentials: Boolean = true

    @Bean
    fun corsConfigurationSource(): CorsConfigurationSource {
        val configuration = CorsConfiguration()
        configuration.allowedOrigins = allowedOrigins.split(",").map { it.trim() }
        configuration.allowedMethods = allowedMethods.split(",").map { it.trim() }
        configuration.allowedHeaders = if (allowedHeaders == "*") listOf("*") else allowedHeaders.split(",").map { it.trim() }
        configuration.allowCredentials = allowCredentials
        configuration.maxAge = 3600L

        val source = UrlBasedCorsConfigurationSource()
        source.registerCorsConfiguration("/**", configuration)
        return source
    }
}


