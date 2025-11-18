package com.expeknow.backend.common.util

import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.security.Keys
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.util.*
import javax.crypto.SecretKey

@Component
class JwtUtil {

    @Value("\${app.jwt.secret}")
    private lateinit var secret: String

    @Value("\${app.jwt.expiration}")
    private var expiration: Long = 0

    private fun getSigningKey(): SecretKey {
        return Keys.hmacShaKeyFor(secret.toByteArray())
    }

    fun generateToken(username: String, additionalClaims: Map<String, Any> = emptyMap()): String {
        val claims = mutableMapOf<String, Any>()
        claims.putAll(additionalClaims)

        return Jwts.builder()
            .claims(claims)
            .subject(username)
            .issuedAt(Date())
            .expiration(Date(System.currentTimeMillis() + expiration))
            .signWith(getSigningKey())
            .compact()
    }

    fun extractUsername(token: String): String? {
        return extractClaims(token)?.subject
    }

    fun extractClaims(token: String): Claims? {
        return try {
            Jwts.parser()
                .verifyWith(getSigningKey())
                .build()
                .parseSignedClaims(token)
                .payload
        } catch (e: Exception) {
            null
        }
    }

    fun isTokenValid(token: String, username: String): Boolean {
        val extractedUsername = extractUsername(token)
        return extractedUsername == username && !isTokenExpired(token)
    }

    private fun isTokenExpired(token: String): Boolean {
        val claims = extractClaims(token)
        return claims?.expiration?.before(Date()) ?: true
    }
}

