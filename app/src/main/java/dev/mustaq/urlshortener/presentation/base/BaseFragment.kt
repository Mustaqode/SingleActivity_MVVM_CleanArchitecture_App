package dev.mustaq.urlshortener.presentation.base

import android.view.View
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController

/**
 * Created by Mustaq Sameer on 10/06/20
 */
open class BaseFragment(@LayoutRes private val resId: Int) : Fragment(resId) {

    protected fun navigate(directions: NavDirections) {
        findNavController().navigate(directions)
    }

    protected fun showError(message: String) {
        Toast.makeText(requireActivity(), message, Toast.LENGTH_SHORT).show()
    }

    protected fun setLoader(progress: View, state: Boolean) {
        when (state) {
            true -> progress.visibility = View.VISIBLE
            false -> progress.visibility = View.INVISIBLE
        }
    }

}