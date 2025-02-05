package com.abhinay.ktorclient.data.remote

import com.abhinay.ktorclient.data.remote.dto.PostRequest
import com.abhinay.ktorclient.data.remote.dto.PostResponse
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.features.logging.LogLevel
import io.ktor.client.features.logging.Logging


/**
 * Created by Abhinay on 05/02/25.
 *
 *
 */
interface PostService {

    suspend fun getPosts(): List<PostResponse>

    suspend fun createPost(postRequest: PostRequest): PostResponse?

    companion object {

        fun create(): PostService {
            return PostsServiceImpl(
                client = HttpClient(Android){
                    install(Logging) {
                        level = LogLevel.ALL
                    }
                    install(JsonFeature) {
                        serializer = KotlinxSerializer()
                    }

                }
            )

        }
    }
}