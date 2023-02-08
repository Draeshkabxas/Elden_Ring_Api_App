package com.example.postsapi.model

object Routes {
    private const val BASE_URL = "https://eldenring.fanapis.com/api"
    const val  BOSSES= "$BASE_URL/bosses?limit=10"
    const val  BOSSES_LIMIT= "$BASE_URL/bosses?limit="
    const val  SPIRIT_LIMIT= "https://eldenring.fanapis.com/api/spirits?limit="
}