package com.example.kindkotlin

import android.graphics.Matrix
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

    var degrees = 0f

    private fun setup() {
        rotateButton.setOnClickListener {
            val matrix = Matrix()
            degrees += 45.0f
            if (degrees >= 360f) {
                degrees = 0f
            }
            matrix.postRotate(degrees, 50f, 50f)
            targetImageView.imageMatrix = matrix
        }
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