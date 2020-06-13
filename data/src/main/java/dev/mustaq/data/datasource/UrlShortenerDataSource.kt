package dev.mustaq.data.datasource

import dev.mustaq.data.mapper.toDomainObject
import dev.mustaq.domain.models.ShortenedUrl
import dev.mustaq.domain.responseutil.ResponseWrapper
import dev.mustaq.data.network.UrlShortenerService

/**
 * Created by Mustaq Sameer on 12/06/20
 */
class UrlShortenerDataSource(private val shrinkUrlService: UrlShortenerService) {

    suspend fun shrinkUrl(url: String): ResponseWrapper<ShortenedUrl, Exception> =
        ResponseWrapper.build {
            shrinkUrlService.shrinkUrl(url).result.toDomainObject
        }


    suspend fun getUrlInfo(code: String): ResponseWrapper<ShortenedUrl, Exception> =
        ResponseWrapper.build {
            shrinkUrlService.getUrlInfo(code).result.toDomainObject
        }

}