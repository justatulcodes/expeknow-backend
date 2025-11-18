package com.expeknow.backend.controller

import com.expeknow.backend.common.dto.ApiResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime

data class HealthCheckResponse(
    val status: String,
    val timestamp: LocalDateTime,
    val service: String,
    val version: String
)

@RestController
@RequestMapping("/api/public")
class HealthController {

    @GetMapping("/health")
    fun health(): ResponseEntity<ApiResponse<HealthCheckResponse>> {
        val healthCheck = HealthCheckResponse(
            status = "UP",
            timestamp = LocalDateTime.now(),
            service = "Expeknow Backend",
            version = "0.0.1-SNAPSHOT"
        )
        return ResponseEntity.ok(ApiResponse.success(healthCheck, "Service is running"))
    }
}

