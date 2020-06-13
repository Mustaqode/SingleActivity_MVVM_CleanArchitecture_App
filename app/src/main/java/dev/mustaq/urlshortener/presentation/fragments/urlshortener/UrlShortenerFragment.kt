package dev.mustaq.urlshortener.presentation.fragments.urlshortener

import android.os.Bundle
import android.view.View
import dev.mustaq.urlshortener.R
import dev.mustaq.urlshortener.presentation.activity.MainViewModel
import dev.mustaq.urlshortener.presentation.base.BaseFragment
import dev.mustaq.utils.livedata.observeLiveData
import kotlinx.android.synthetic.main.fragment_shorcode_generator.*
import kotlinx.android.synthetic.main.fragment_shorcode_generator.uiEtEnterUrl
import kotlinx.android.synthetic.main.fragment_shorcode_generator.uiProgressBar
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Created by Mustaq Sameer on 10/06/20
 */

/**
 * Since we have added {navigation_fragment_ktx} library, we can pass the layout
 * directly into the constructor of the class; making `onCreateView()` method redundant
 * in most cases
 */
class UrlShortenerFragment : BaseFragment(R.layout.fragment_shorcode_generator) {

    /**
     * We can share a view model among a list of fragments which is
     * grouped under a navigation graph.
     */
    private val mainViewModel: MainViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUi()
        setListeners()
    }

    private fun setupUi() {
        mainViewModel.loader.observeLiveData(viewLifecycleOwner) { setLoader(uiProgressBar, it) }
        mainViewModel.error.observeLiveData(viewLifecycleOwner) { showError(it) }
        mainViewModel.direction.observeLiveData(viewLifecycleOwner) { navigate(it) }
        mainViewModel.shortenedUrl.observeLiveData(viewLifecycleOwner) {
            uiTvResult.text = it
        }
    }

    private fun setListeners() {
        uiBtnShorten.setOnClickListener {
            mainViewModel.shortenTheUrl(uiEtEnterUrl.text)
        }
        uiTvMoveToInfoPage.setOnClickListener {
            mainViewModel.goToNavigationInfoPage(uiTvResult.text.toString())
        }
    }

}