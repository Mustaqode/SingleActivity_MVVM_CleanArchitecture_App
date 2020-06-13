package dev.mustaq.urlshortener

import android.app.Application
import dev.mustaq.urlshortener.framework.koin.commonModules
import dev.mustaq.urlshortener.framework.koin.dataSourceModule
import dev.mustaq.urlshortener.framework.koin.repositoryModule
import dev.mustaq.urlshortener.framework.koin.viewModelModule
import org.koin.core.context.startKoin

/**
 * Created by Mustaq Sameer on 12/06/20
 */
class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        configKoin()
    }

    private fun configKoin() {
        startKoin {
            modules(
                listOf(
                    commonModules,
                    viewModelModule,
                    dataSourceModule,
                    repositoryModule
                )
            )
        }
    }
}