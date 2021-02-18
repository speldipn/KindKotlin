package com.example.kindkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_calc.*
import java.util.*

class CalcActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setup()
    }

    private val getOperator = { oper: String ->
        when (oper.toLowerCase(Locale.getDefault())) {
            "add" -> { a: Int, b: Int -> a + b }
            "minus" -> { a: Int, b: Int -> a - b }
            "mul" -> { a: Int, b: Int -> a * b }
            "div" -> { a: Int, b: Int -> a / b }
            else -> null
        }
    }

    private fun setup() {
        val clickListener = View.OnClickListener { v ->
            val operFunc = when (v.id) {
                R.id.plusButton -> getOperator("add")
                R.id.minusButton -> getOperator("minus")
                R.id.mulButton -> getOperator("mul")
                R.id.divButton -> getOperator("div")
                else -> getOperator("")
            }
            operFunc?.let {
                val a = editText1.text.toString().trim().toInt()
                val b = editText2.text.toString().trim().toInt()
                resultTextView.text = "${it(a, b)}"
            }
        }
        plusButton.setOnClickListener(clickListener)
        minusButton.setOnClickListener(clickListener)
        mulButton.setOnClickListener(clickListener)
        divButton.setOnClickListener(clickListener)
    }

    fun debug(msg: String) {
        Log.d("spdn", "${debugNumber++}: $msg")
    }

    companion object {
        var debugNumber = 0
    }
}
