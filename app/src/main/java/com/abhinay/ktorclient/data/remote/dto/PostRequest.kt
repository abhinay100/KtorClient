package com.abhinay.ktorclient.data.remote.dto

import android.icu.text.CaseMap.Title
import kotlinx.serialization.Serializable


/**
 * Created by Abhinay on 05/02/25.
 *
 *
 */
@Serializable
data class PostRequest (
    val body: String,
    val title: String,
    val userId: Int
)