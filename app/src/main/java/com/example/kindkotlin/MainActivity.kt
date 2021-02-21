package com.example.kindkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var loginFragment:LoginFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setup()
    }


    private fun setup() {
        loginFragment = LoginFragment()
        supportFragmentManager.beginTransaction()
            .add(R.id.container, loginFragment)
            .addToBackStack("")
            .commit()
    }

    fun debug(msg: String) {
        val formatted = String.format("Line%2d: %s", debugNumber++, msg)
        Log.d("spdn", formatted)
    }

    companion object {
        var debugNumber = 0
    }
}