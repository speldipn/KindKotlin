package com.example.kindkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setup()
    }

    private fun setup() {

    }

    fun debug(msg: String) {
        Log.d("spdn", "${debugNumber++}: $msg")
    }

    companion object {
        var debugNumber = 0
    }
}