package com.mycodinglab.angelapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.mycodinglab.angelapp.databinding.ActivityMain2Binding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private var binding: ActivityMain2Binding? = null
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding?.root)

        setUpNavigation();
    }


    private fun setUpNavigation() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(
                R
                .id.fragmentContainerView) as NavHostFragment
        navController = navHostFragment.navController

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(R.id.navigation_headlines)
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        binding?.bottomNavigationView?.setupWithNavController(navController)
        binding?.bottomNavigationView?.setOnNavigationItemReselectedListener {
            // Do nothing to ignore the reselection
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}