package dev.mustaq.data.network

import dev.mustaq.data.model.Info
import dev.mustaq.data.model.ShortUrl
import dev.mustaq.data.model.Shorten
import dev.mustaq.data.model.UrlInfo

/**
 * Created by Mustaq Sameer on 12/06/20
 */
interface UrlShortenerService {

    suspend fun shrinkUrl(url: String): Shorten

    suspend fun getUrlInfo(code: String) : Info

}