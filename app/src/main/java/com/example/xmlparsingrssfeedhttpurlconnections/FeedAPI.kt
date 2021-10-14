package com.example.xmlparsingrssfeedhttpurlconnections

import com.example.xmlparsingrssfeedhttpurlconnections.model.RSS
import retrofit2.Call
import retrofit2.http.GET

interface RSSAPI {
    @get:GET("blog/feed/")
    val rss: Call<RSS?>?

    companion object {
        const val BASE_URL = "https://www.floretflowers.com/"
    }
}