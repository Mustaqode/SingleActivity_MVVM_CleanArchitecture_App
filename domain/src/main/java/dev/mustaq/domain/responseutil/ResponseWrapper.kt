package dev.mustaq.domain.responseutil

import java.lang.Exception

/**
 * Created by Mustaq Sameer on 12/06/20
 */

sealed class ResponseWrapper<out D, out E> {

    data class Data<out D>(
        val data: D
    ) : ResponseWrapper<D, Nothing>()

    data class Error<out E>(
        val error: E
    ) : ResponseWrapper<Nothing, E>()

    companion object {
        inline fun <D> build(function: () -> D): ResponseWrapper<D, Exception> =
            try {
                Data(function())
            } catch (e: Exception) {
                Error(e)
            }
    }

}