package com.example.postsapi.model

// To parse the JSON, install kotlin's serialization plugin and do:
//
// val json    = Json { allowStructuredMapKeys = true }
// val welcome = json.parse(Welcome.serializer(), jsonString)

import kotlinx.serialization.*



@Serializable
data class Welcome (
    val success: Boolean,
    val count: Long,
    val total: Long,
    val data: List<Boss>
)

@Serializable
@SerialName("Datum")
data class Boss(
    val id: String,
    val name: String,
    val image: String? = null,
    val region: String,
    val description: String,
    val location: String,
    val drops: List<String>,
    val healthPoints: String? = null
)
@Serializable
@SerialName("Welcome")
data class SpiritResponded (
    val success: Boolean,
    val count: Long,
    val total: Long,
    val data: List<Spirit>
)

@Serializable
@SerialName("Datum")
data class Spirit (
    val id: String,
    val name: String,
    val image: String,
    val description: String,
    val fpCost: String,
    val hpCost: String,
    val effect: String
)

