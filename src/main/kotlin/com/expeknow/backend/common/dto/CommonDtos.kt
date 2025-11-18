package com.expeknow.backend.common.dto

data class ApiResponse<T>(
    val success: Boolean,
    val message: String? = null,
    val data: T? = null
) {
    companion object {
        fun <T> success(data: T?, message: String? = null): ApiResponse<T> {
            return ApiResponse(success = true, message = message, data = data)
        }

        fun <T> error(message: String): ApiResponse<T> {
            return ApiResponse(success = false, message = message, data = null)
        }
    }
}

data class PageResponse<T>(
    val content: List<T>,
    val page: Int,
    val size: Int,
    val totalElements: Long,
    val totalPages: Int,
    val last: Boolean
)


