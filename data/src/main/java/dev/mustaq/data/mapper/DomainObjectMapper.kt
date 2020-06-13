package dev.mustaq.data.mapper

import dev.mustaq.data.model.ShortUrl
import dev.mustaq.data.model.UrlInfo
import dev.mustaq.domain.constants.DEFAULT_URL
import dev.mustaq.domain.models.ShortenedUrl

/**
 * Created by Mustaq Sameer on 12/06/20
 */

internal val ShortUrl.toDomainObject
    get() = ShortenedUrl(
        shortUrl = this.shortUrl,
        originalUrl = this.originalUrl,
        code = this.code
    )

internal val UrlInfo.toDomainObject
    get() = ShortenedUrl(
        originalUrl = this.originalUrl,
        shortUrl = "$DEFAULT_URL${this.code}", //Example: https://shrtco.de/DdIc
        code = this.code

    )