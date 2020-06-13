package dev.mustaq.urlshortener.framework.koin

import dev.mustaq.data.datasource.UrlShortenerDataSource
import dev.mustaq.data.repository.UrlInfoRepoImpl
import dev.mustaq.data.repository.UrlShrinkRepoImpl
import dev.mustaq.urlshortener.framework.rest.Rest
import dev.mustaq.urlshortener.framework.rest.UrlShortenerService
import dev.mustaq.urlshortener.presentation.activity.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by Mustaq Sameer on 12/06/20
 */

val commonModules = module {
    single { Rest.service }
}

val viewModelModule = module {
    viewModel { MainViewModel(get(),get()) }
}

val dataSourceModule = module {
    single { UrlShortenerDataSource(get()) }
    single<dev.mustaq.data.network.UrlShortenerService> { UrlShortenerService(get()) }
}

val repositoryModule = module {
    single { UrlShrinkRepoImpl(get()) }
    single { UrlInfoRepoImpl(get()) }
}