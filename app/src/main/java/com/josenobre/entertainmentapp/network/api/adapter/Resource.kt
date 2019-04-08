package com.josenobre.entertainmentapp.network.api.adapter

data class Resource<T>(val status: Status, val code: Int, val data: T?, val message: String?) {

    companion object {

        fun <T> success(code: Int, data: T?) = Resource(Status.SUCCESS, code, data, null)

        fun <T> error(message: String?, code: Int, data: T?) = Resource(Status.ERROR, code, data, message)

        fun <T> loading(data: T? = null, code: Int = 0) = Resource(Status.LOADING, code, data, null)

        fun <T> empty(status: Status, code: Int, message: String?, data: T? = null) =
            Resource(status, code, data, message)
    }
}