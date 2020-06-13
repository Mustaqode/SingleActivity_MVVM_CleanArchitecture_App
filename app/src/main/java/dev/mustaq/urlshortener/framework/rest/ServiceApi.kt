package dev.mustaq.urlshortener.framework.rest

import dev.mustaq.data.model.Info
import dev.mustaq.data.model.Shorten
import retrofit2.http.POST
import retrofit2.http.Query

/**
 * Created by Mustaq Sameer on 12/06/20
 */
interface ServiceApi {

    @POST("shorten")
    suspend fun shrinkUrl(@Query("url") url: String) : Shorten

    @POST("info")
    suspend fun getUrlInfo (@Query("code") code: String) : Info

}