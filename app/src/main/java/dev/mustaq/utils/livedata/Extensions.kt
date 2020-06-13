package dev.mustaq.utils.livedata

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

/**
 * Created by Mustaq Sameer on 12/06/20
 */

inline fun <T> LiveData<T>.observeLiveData(
    lifecycleOwner: LifecycleOwner,
    crossinline block: (T) -> Unit
) {
    observe(lifecycleOwner, Observer {
        block(it)
    })
}