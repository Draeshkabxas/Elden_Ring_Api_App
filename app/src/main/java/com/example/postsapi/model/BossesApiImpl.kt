package com.example.postsapi.model
import android.util.Log
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.*
import io.ktor.client.request.*

/**
 * Created by Taha Ben Ashur (https://github.com/tahaak67) on 04,Feb,2023
 */
class BossesApiImpl(
    private val client: HttpClient
): BossesAPi {
    override suspend fun getBosses(): List<Boss> {
        return getBossesLimitBy(10)
    }

    override suspend fun getBossesLimitBy(limit: Int): List<Boss> {
        return try {
            val welcome:Welcome= client.get {
                url(Routes.BOSSES_LIMIT+limit)
            }.body()
            welcome.data
        } catch (e: RedirectResponseException) {
            Log.e("PostsApi", "3XX Error: ${e.message}")
            emptyList()
        } catch (e: ClientRequestException) {
            Log.e("PostsApi", "4XX Error: ${e.message}")
            emptyList()
        } catch (e: ServerResponseException) {
            Log.e("PostsApi", "5XX Error: ${e.message}")
            emptyList()
        } catch (e: Exception) {
            Log.e("PostsApi", "Error: ${e.message}")
            emptyList()
        }
    }

    override suspend fun getSpiritLimitBy(limit: Int): List<Spirit> {
        return try {
            val welcome:SpiritResponded= client.get {
                url(Routes.SPIRIT_LIMIT+limit)
            }.body()
            welcome.data
        } catch (e: RedirectResponseException) {
            Log.e("PostsApi", "3XX Error: ${e.message}")
            emptyList()
        } catch (e: ClientRequestException) {
            Log.e("PostsApi", "4XX Error: ${e.message}")
            emptyList()
        } catch (e: ServerResponseException) {
            Log.e("PostsApi", "5XX Error: ${e.message}")
            emptyList()
        } catch (e: Exception) {
            Log.e("PostsApi", "Error: ${e.message}")
            emptyList()
        }
    }
}
