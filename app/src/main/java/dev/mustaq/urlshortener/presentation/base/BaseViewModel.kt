package dev.mustaq.urlshortener.presentation.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections
import dev.mustaq.utils.livedata.SingleLiveData
import java.util.concurrent.atomic.AtomicBoolean

/**
 * Created by Mustaq Sameer on 10/06/20
 */
open class BaseViewModel : ViewModel() {

    protected val progressLoader = AtomicBoolean()

    protected val directionsLd = SingleLiveData<NavDirections>()
    protected val errorLd = SingleLiveData<String>()
    protected val loaderLd = MutableLiveData<Boolean>()

    val direction: LiveData<NavDirections> = directionsLd
    val error: LiveData<String> = errorLd
    val loader: LiveData<Boolean> = loaderLd

}