package com.example.kindkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val homeFragment by lazy { HomeFragment() }
    val userFragment by lazy { UserFragment() }
    val settingFragment by lazy { SettingFragment() }
    val fragments = listOf(homeFragment, userFragment, settingFragment)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setup()
    }

    private fun setup() {
        supportFragmentManager.beginTransaction()
            .add(R.id.container, fragments[0])
            .commit()

        setSupportActionBar(toolBar)

        val toggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            toolBar,
            R.string.drawer_open,
            R.string.drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        navigationView.setNavigationItemSelectedListener { v ->
            when(v.itemId) {
                R.id.item1 -> selectFragment(0)
                R.id.item2 -> selectFragment(1)
                R.id.item3 -> selectFragment(2)
            }
            drawerLayout.closeDrawer(GravityCompat.START)
           return@setNavigationItemSelectedListener true
        }
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    private fun selectFragment(index: Int) {
        when (index) {
            0 -> {
                toolBar.title = "Home"
                supportFragmentManager.beginTransaction().replace(R.id.container, fragments[0]).commit()
            }
            1 -> {
                toolBar.title = "User"
                supportFragmentManager.beginTransaction().replace(R.id.container, fragments[1]).commit()
            }
            2 -> {
                toolBar.title ="Setting"
                supportFragmentManager.beginTransaction().replace(R.id.container, fragments[2]).commit()
            }
        }
    }

    fun debug(msg: String) {
        val formatted = String.format("Line%2d: %s", debugNumber++, msg)
        Log.d("spdn", formatted)
    }

    companion object {
        var debugNumber = 0
    }
}