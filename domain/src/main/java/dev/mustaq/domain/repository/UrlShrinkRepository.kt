package dev.mustaq.domain.repository

import dev.mustaq.domain.models.ShortenedUrl
import dev.mustaq.domain.responseutil.ResponseWrapper


/**
 * Created by Mustaq Sameer on 12/06/20
 */

interface UrlShrinkRepository {

    suspend fun shortenUrl(url: String) : ResponseWrapper<ShortenedUrl, Exception>

}