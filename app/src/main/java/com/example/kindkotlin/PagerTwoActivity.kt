package com.example.kindkotlin

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.activity_pager_two.*

class PagerTwoActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pager_two)
        setup()
    }

    private fun setup() {
        viewPager.adapter = CustomPagerAdapter(this)
        viewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
//        viewPager.orientation = ViewPager2.ORIENTATION_VERTICAL
        viewPager.offscreenPageLimit = 3

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                showToast("${position + 1} selected!")
            }
        })

        val clickListener = View.OnClickListener { v ->
            when(v.id) {
                R.id.oneButton -> viewPager.currentItem = 0
                R.id.twoButton -> viewPager.currentItem = 1
                R.id.threeButton -> viewPager.currentItem = 2
            }
        }
        oneButton.setOnClickListener(clickListener)
        twoButton.setOnClickListener(clickListener)
        threeButton.setOnClickListener(clickListener)
    }

    inner class CustomPagerAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {
        override fun getItemCount(): Int = 3

        override fun createFragment(position: Int): Fragment {
            return when (position) {
                0 -> HomeFragment()
                1 -> UserFragment()
                else -> SettingFragment()
            }
        }
    }

    fun showToast(msg: String) = Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()

}