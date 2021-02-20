package com.example.kindkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.custom_card_item.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setup()
    }

    private fun setup() {
        val clickListener = View.OnClickListener { v ->
            when (v.id) {
                R.id.button1 -> {
                    customCardView.setProfileImage(R.drawable.ic_launcher_background)
                }
                R.id.button2 -> {
                    customCardView.setProfileImage(R.drawable.ic_launcher_foreground)
                }
            }
        }
        button1.setOnClickListener(clickListener)
        button2.setOnClickListener(clickListener)
        customCardView.setName("오주렁")
        customCardView.setPhone("01033334444")
    }

    private fun debug(msg: String) {
        val formatted = String.format("Line%2d: %s", debugNumber++, msg)
        Log.d("spdn", formatted)
    }

    companion object {
        var debugNumber = 0
    }

//    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
//        super.onRestoreInstanceState(savedInstanceState)
//        debug("onRestoreInstanceState $savedInstanceState")
//    }
//
//    override fun onSaveInstanceState(outState: Bundle) {
//        super.onSaveInstanceState(outState)
//        debug("onSaveInstanceState $outState")
//    }

//    override fun onStart() {
//        super.onStart()
//        debug("onStart")
//    }
//
//    override fun onResume() {
//        super.onResume()
//        debug("onResume")
//    }
//
//    override fun onPause() {
//        super.onPause()
//        debug("onPause")
//    }
//
//    override fun onStop() {
//        super.onStop()
//        debug("onStop")
//    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//        debug("onDestroy")
//    }
//
//    override fun onRestart() {
//        super.onRestart()
//        debug("onRestart")
//    }
}