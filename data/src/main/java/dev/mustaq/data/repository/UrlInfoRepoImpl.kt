package dev.mustaq.data.repository

import dev.mustaq.data.datasource.UrlShortenerDataSource
import dev.mustaq.domain.models.ShortenedUrl
import dev.mustaq.domain.repository.UrlInfoRepository
import dev.mustaq.domain.responseutil.ResponseWrapper

/**
 * Created by Mustaq Sameer on 12/06/20
 */
class UrlInfoRepoImpl(private val urlInfoDataSource: UrlShortenerDataSource) : UrlInfoRepository {

    override suspend fun getUrlInfo(code: String): ResponseWrapper<ShortenedUrl, Exception> =
        urlInfoDataSource.getUrlInfo(code)

}