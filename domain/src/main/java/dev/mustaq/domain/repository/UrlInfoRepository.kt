package dev.mustaq.domain.repository

import dev.mustaq.domain.models.ShortenedUrl

/**
 * Created by Mustaq Sameer on 12/06/20
 */

interface UrlInfoRepository {

    suspend fun getUrlInfo(code: String) : dev.mustaq.domain.responseutil.ResponseWrapper<ShortenedUrl, Exception>

}