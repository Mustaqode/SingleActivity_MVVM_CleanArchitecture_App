package dev.mustaq.data.repository

import dev.mustaq.data.datasource.UrlShortenerDataSource
import dev.mustaq.domain.models.ShortenedUrl
import dev.mustaq.domain.repository.UrlShrinkRepository
import dev.mustaq.domain.responseutil.ResponseWrapper

/**
 * Created by Mustaq Sameer on 12/06/20
 */
class UrlShrinkRepoImpl(private val shrinkUrlDataSource: UrlShortenerDataSource) :
    UrlShrinkRepository {

    override suspend fun shortenUrl(url: String): ResponseWrapper<ShortenedUrl, Exception> =
        shrinkUrlDataSource.shrinkUrl(url)
}