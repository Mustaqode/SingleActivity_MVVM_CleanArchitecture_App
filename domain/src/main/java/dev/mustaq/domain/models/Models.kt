package dev.mustaq.domain.models

/**
 * Created by Mustaq Sameer on 12/06/20
 */

data class ShortenedUrl(
    val shortUrl: String,
    val originalUrl: String,
    val code: String
)
