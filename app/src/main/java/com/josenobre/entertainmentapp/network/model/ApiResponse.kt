package com.josenobre.entertainmentapp.network.model

import retrofit2.Response

@Suppress("unused")
open class ApiResponse<T> {

    companion object {
        fun <T> create(url: String, throwable: Throwable): ApiErrorResponse<T> {
            return ApiErrorResponse(url, 520, throwable.message ?: "Something went wrong")
        }

        fun <T> create(url: String, response: Response<T>): ApiResponse<T> {
            return if (response.isSuccessful) {
                val body = response.body()
                ApiSuccessResponse(url, body)
            } else {
                val code = response.code()
                val message = response.errorBody()?.string()
                val errorMessage = if (message.isNullOrEmpty()) {
                    response.message()
                } else {
                    message
                }
                ApiErrorResponse(url, code, errorMessage ?: "Something went wrong")
            }
        }
    }
}

data class ApiSuccessResponse<T>(val url: String, val body: T?) : ApiResponse<T>()

data class ApiErrorResponse<T>(val url: String, val errorCode: Int, val errorMessage: String) : ApiResponse<T>()
