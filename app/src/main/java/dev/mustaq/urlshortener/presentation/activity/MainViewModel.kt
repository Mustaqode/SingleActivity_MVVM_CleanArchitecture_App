package dev.mustaq.urlshortener.presentation.activity

import android.text.Editable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dev.mustaq.data.repository.UrlInfoRepoImpl
import dev.mustaq.data.repository.UrlShrinkRepoImpl
import dev.mustaq.domain.responseutil.ResponseWrapper.*
import dev.mustaq.urlshortener.presentation.base.BaseViewModel
import dev.mustaq.urlshortener.presentation.fragments.urlshortener.UrlShortenerFragmentDirections
import kotlinx.coroutines.launch
import java.util.concurrent.atomic.AtomicBoolean

/**
 * Created by Mustaq Sameer on 10/06/20
 */

class MainViewModel(
    private val urlShrinkRepo: UrlShrinkRepoImpl,
    private val urlInfoRepo: UrlInfoRepoImpl
) : BaseViewModel() {

    private val shortenedUrlLd = MutableLiveData<String>()
    private val urlInfoLd = MutableLiveData<String>()

    val shortenedUrl: LiveData<String> = shortenedUrlLd
    val urlInfo: LiveData<String> = urlInfoLd

    fun shortenTheUrl(url: Editable?) {
        setLoader(true)
        viewModelScope.launch {
            val response =
                urlShrinkRepo.shortenUrl(url.toString())
            setLoader(false)
            when (response) {
                is Data -> {
                    shortenedUrlLd.value = response.data.shortUrl
                }
                is Error -> {
                    errorLd.value = response.error.toString()
                }
            }
        }
    }

    fun goToNavigationInfoPage(url: String?) {
        if (url != null) {
            val direction =
                UrlShortenerFragmentDirections.actionShortenerPageToUrlPage()
            directionsLd.value = direction
        }
    }

    //Called from UrlInfoFragment
    fun getUrlInfo(code: String) {
        setLoader(true)
        viewModelScope.launch {
            val response = urlInfoRepo.getUrlInfo(code)
            setLoader(false)
            when (response) {
                is Data -> {
                    urlInfoLd.value = response.data.originalUrl
                }
                is Error -> {
                    errorLd.value = response.error.message
                }
            }
        }
    }

    fun setLoader(state: Boolean) {
        progressLoader.set(state)
        loaderLd.value = progressLoader.compareAndSet(true, false)
    }

}