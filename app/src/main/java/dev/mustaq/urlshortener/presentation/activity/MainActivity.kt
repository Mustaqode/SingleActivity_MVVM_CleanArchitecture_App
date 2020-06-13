package dev.mustaq.urlshortener.presentation.activity

import android.graphics.PorterDuff
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import dev.mustaq.urlshortener.R
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by Mustaq Sameer on 10/06/20
 */

/**
 * Notes for new programmers -->
 * Navigation controller -> The fragment which is the host and controls entire fragment navigation.
 * AppbarConfiguration -> Configure Appbar with the navController. i.e. Change title according to the fragment label
 * onNavigateUp() -> controls the navigation button
 * set -> It is an immutable collection that doesn't allow duplicates
 */

class MainActivity : AppCompatActivity() {

    private val navigationController by lazy { findNavController(R.id.nav_host_fragment) }
    private val appBarConfiguration by lazy { AppBarConfiguration(navigationController.graph) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupUi()
    }

    private fun setupUi() {
        uiToolbar.setupWithNavController(navigationController, appBarConfiguration)
    }

}
