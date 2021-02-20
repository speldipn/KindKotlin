package com.example.kindkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_sub.*

class SubActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)
        closeButton.setOnClickListener { finish() }
        debug("onCreate")
    }

    override fun onStart() {
        super.onStart()
        debug("onStart")
    }

    override fun onResume() {
        super.onResume()
        debug("onResume")
    }

    override fun onPause() {
        super.onPause()
        debug("onPause")
    }

    override fun onStop() {
        super.onStop()
        debug("onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        debug("onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        debug("onRestart")
    }

    private fun debug(msg: String) = Log.d("spdn", "Sub ${debugNumber++}: $msg")

    companion object {
        var debugNumber = 0
    }

}