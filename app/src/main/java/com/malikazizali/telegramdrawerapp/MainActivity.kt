package com.malikazizali.telegramdrawerapp

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.malikazizali.telegramdrawerapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    lateinit var drawerLayout: DrawerLayout
    private lateinit var mToggle : ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMain.toolbar)

        binding.appBarMain.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show()
        }

        drawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_group,
                R.id.nav_contacts,
                R.id.nav_calls,
                R.id.nav_nearby,
                R.id.nav_saved_messages,
                R.id.nav_settings,
                R.id.nav_invite,
                R.id.nav_features
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        mToggle = ActionBarDrawerToggle(this, drawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawerLayout.addDrawerListener(mToggle)
        mToggle.syncState()

        navView.setNavigationItemSelectedListener(this)

    }

    override fun onOptionsItemSelected(item: android.view.MenuItem): Boolean {
        return mToggle.onOptionsItemSelected(item)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_group -> {
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.nav_host_fragment_content_main, NewGroupFragment())
                    commit()
                }
                true
            }
            R.id.nav_contacts -> {
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.nav_host_fragment_content_main, ContactsFragment())
                    commit()
                }
                true
            }
            R.id.nav_calls -> {
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.nav_host_fragment_content_main, CallsFragment())
                    commit()
                }
                true
            }
            R.id.nav_nearby -> {
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.nav_host_fragment_content_main, NearbyFragment())
                    commit()
                }
                true
            }
            R.id.nav_saved_messages -> {
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.nav_host_fragment_content_main, SavedMessageFragment())
                    commit()
                }
                true
            }
            R.id.nav_settings -> {
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.nav_host_fragment_content_main, SettingsFragment())
                    commit()
                }
                true
            }
            R.id.nav_invite -> {
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.nav_host_fragment_content_main, InviteFragment())
                    commit()
                }
                true
            }
            R.id.nav_features -> {
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.nav_host_fragment_content_main, FeaturesFragment())
                    commit()
                }
                true
            }
            else -> drawerLayout.closeDrawer(GravityCompat.START)
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

}
