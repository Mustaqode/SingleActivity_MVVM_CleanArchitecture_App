package dev.mustaq.data.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Mustaq Sameer on 12/06/20
 */

data class Shorten(
    val result: ShortUrl
)

data class Info(
    val result: UrlInfo
)

data class ShortUrl(
    @SerializedName("full_short_link")
    val shortUrl: String,
    @SerializedName ("original_link")
    val originalUrl: String,
    val code: String
)

data class UrlInfo(
    @SerializedName("url")
    val originalUrl: String,
    val code: String
)