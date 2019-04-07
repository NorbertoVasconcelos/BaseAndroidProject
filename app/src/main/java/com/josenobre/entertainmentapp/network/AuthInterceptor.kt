package com.josenobre.entertainmentapp.network

import androidx.annotation.NonNull
import com.josenobre.entertainmentapp.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException


/**
 * Default constructor.
 */
class AuthInterceptor : Interceptor {

    @Throws(IOException::class)
    override fun intercept(@NonNull chain: Interceptor.Chain): Response {
        var request = chain.request()
        val url = request.url().newBuilder()
            .addQueryParameter("api_key", BuildConfig.API_KEY)
            .build()
        request = request.newBuilder().url(url).build()
        return chain.proceed(request)
    }
}
