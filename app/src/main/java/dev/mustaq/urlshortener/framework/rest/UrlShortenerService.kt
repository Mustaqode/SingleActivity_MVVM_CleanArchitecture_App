package dev.mustaq.urlshortener.framework.rest

import dev.mustaq.data.model.Info
import dev.mustaq.data.model.Shorten
import dev.mustaq.data.network.UrlShortenerService

/**
 * Created by Mustaq Sameer on 12/06/20
 */
class UrlShortenerService(private val serviceApi: ServiceApi) : UrlShortenerService {

    override suspend fun shrinkUrl(url: String): Shorten =
        serviceApi.shrinkUrl(url)


    override suspend fun getUrlInfo(code: String): Info =
         serviceApi.getUrlInfo(code)

}