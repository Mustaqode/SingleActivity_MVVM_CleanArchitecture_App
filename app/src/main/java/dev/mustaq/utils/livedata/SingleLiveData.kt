package dev.mustaq.utils.livedata

import androidx.annotation.MainThread
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import java.util.concurrent.atomic.AtomicBoolean

/**
 * Created by Mustaq Sameer on 12/06/20
 */

/**
 * Found the solution in stackOverFLow. This is to solve the following problem.
 * My fragment (frag1) has active observer which is responsible for navigating
 * to other fragment (frag2) ; when I navigate to frag2 and click back-navigation button,
 * it seems like it is not coming back to frag1 even though it does, and goes back
 * to frag1 within a fraction of a second; the reason is that the
 * viewmodel is shared and hasn't been destroyed while moving from frag1 - frag2;
 * it contains the same navigate value which again navigates us to frag2 faster..
 */

class SingleLiveData<T> : MutableLiveData<T>() {

    private val pending = AtomicBoolean()

    /**
     * Adds the given observer to the observers list within the lifespan of the given
     * owner. The events are dispatched on the main thread. If LiveData already has data
     * set, it will be delivered to the observer.
     *
     * @param owner The LifecycleOwner which controls the observer
     * @param observer The observer that will receive the events
     * @see MutableLiveData.observe
     */
    @MainThread
    override fun observe(owner: LifecycleOwner, observer: Observer<in T>) {
        super.observe(owner, Observer { t ->
            if (pending.compareAndSet(true, false)) {
                observer.onChanged(t)
            }
        })
    }

    /**
     * Sets the value. If there are active observers, the value will be dispatched to them.
     *
     * @param value The new value
     * @see MutableLiveData.setValue
     */
    @MainThread
    override fun setValue(value: T?) {
        pending.set(true)
        super.setValue(value)
    }

}