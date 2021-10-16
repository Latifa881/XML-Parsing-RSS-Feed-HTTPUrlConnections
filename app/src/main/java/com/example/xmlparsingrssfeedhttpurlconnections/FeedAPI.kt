package com.example.xmlparsingrssfeedhttpurlconnections

import retrofit2.Call
import retrofit2.http.GET

interface RSSAPI {
    @get:GET("blog/feed/")
    val rssFloreFlowers: Call<RSS?>?

}