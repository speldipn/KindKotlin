package com.example.kindkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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
        bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.homeTab -> { selectFragment(0) }
                R.id.userTab -> { selectFragment(1) }
                R.id.settingTab -> { selectFragment(2) }
            }
            return@setOnNavigationItemSelectedListener true
        }
    }

    fun selectFragment(index: Int) {
        when (index) {
            0 -> supportFragmentManager.beginTransaction().replace(R.id.container, fragments[0]).commit()
            1 -> supportFragmentManager.beginTransaction().replace(R.id.container, fragments[1]).commit()
            2 -> supportFragmentManager.beginTransaction().replace(R.id.container, fragments[2]).commit()
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