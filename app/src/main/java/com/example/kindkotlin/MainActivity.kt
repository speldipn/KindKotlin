package com.example.kindkotlin

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.widget.FrameLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var startX = 0
    var startY = 0
    var leftMargin = 0
    var topMargin = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setup()
    }


    @SuppressLint("ClickableViewAccessibility")
    private fun setup() {
        imageView.setOnTouchListener { v, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                   debug("down ${event.x} ${event.y}")

                    startX = event.x.toInt()
                    startY = event.y.toInt()
                }
                MotionEvent.ACTION_MOVE -> {
                   debug("move ${event.x} ${event.y}")

                    val diffX = event.x - startX
                    val diffY = event.y - startY
                    leftMargin += diffX.toInt()
                    topMargin += diffY.toInt()

                    val layoutParams = FrameLayout.LayoutParams(
                        FrameLayout.LayoutParams.WRAP_CONTENT,
                        FrameLayout.LayoutParams.WRAP_CONTENT
                    )
                    layoutParams.leftMargin = leftMargin
                    layoutParams.topMargin = topMargin

                    imageView.layoutParams = layoutParams
                }
//                MotionEvent.ACTION_UP -> {
//                   debug("up ${event.x} ${event.y}")
//
//                    val diffX = event.x - startX
//                    val diffY = event.y - startY
//                    leftMargin += diffX.toInt()
//                    topMargin += diffY.toInt()
//                }
            }
            return@setOnTouchListener true
        }
    }

    private fun debug(msg: String) {
        val formatted = String.format("Line%2d: %s", debugNumber++, msg)
        Log.d("spdn", formatted)
    }

    companion object {
        var debugNumber = 0
    }
}