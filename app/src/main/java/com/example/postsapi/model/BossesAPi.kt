package com.example.postsapi.model

interface BossesAPi {
    suspend fun getBosses():List<Boss>
    suspend fun getBossesLimitBy(limit:Int):List<Boss>
    suspend fun getSpiritLimitBy(limit:Int):List<Spirit>
}