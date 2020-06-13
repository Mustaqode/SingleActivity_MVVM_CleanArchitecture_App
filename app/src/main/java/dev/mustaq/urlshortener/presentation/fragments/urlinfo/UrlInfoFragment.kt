package dev.mustaq.urlshortener.presentation.fragments.urlinfo

import android.os.Bundle
import android.view.View
import androidx.navigation.navGraphViewModels
import dev.mustaq.urlshortener.R
import dev.mustaq.urlshortener.presentation.activity.MainViewModel
import dev.mustaq.urlshortener.presentation.base.BaseFragment
import dev.mustaq.utils.livedata.observeLiveData
import kotlinx.android.synthetic.main.fragment_shortcode_info.*
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Created by Mustaq Sameer on 10/06/20
 */
class UrlInfoFragment : BaseFragment(R.layout.fragment_shortcode_info) {

    private val mainViewModel: MainViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUi()
        setListeners()
    }

    private fun setupUi() {
        mainViewModel.loader.observeLiveData(viewLifecycleOwner) { setLoader(uiProgressBar, it) }
        mainViewModel.error.observeLiveData(viewLifecycleOwner) { showError(it) }
        mainViewModel.urlInfo.observeLiveData(viewLifecycleOwner) { uiTvInfo.text = it }
    }

    private fun setListeners() {
        uiBtnGetInfo.setOnClickListener {
            mainViewModel.getUrlInfo(uiEtEnterCode.text.toString())
        }
    }

}