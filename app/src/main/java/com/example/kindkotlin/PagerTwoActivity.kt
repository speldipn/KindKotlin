package com.example.kindkotlin

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.activity_pager.view.*
import kotlinx.android.synthetic.main.activity_pager_two.*
import kotlinx.android.synthetic.main.activity_pager_two.view.*
import me.relex.circleindicator.CircleIndicator2

class PagerTwoActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pager_two)
        setup()
    }

    private fun setup() {
        pager.adapter = CustomPagerAdapter(this)
        pager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
//        pager.orientation = ViewPager2.ORIENTATION_VERTICAL
        pager.offscreenPageLimit = 3

        pager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                indicator.animatePageSelected(position)
                showToast("${position + 1} selected!")
            }
        })

        val clickListener = View.OnClickListener { v ->
            when(v.id) {
                R.id.oneButton -> pager.currentItem = 0
                R.id.twoButton -> pager.currentItem = 1
                R.id.threeButton -> pager.currentItem = 2
            }
        }
        oneButton.setOnClickListener(clickListener)
        twoButton.setOnClickListener(clickListener)
        threeButton.setOnClickListener(clickListener)

        indicator.setViewPager(pager)
        indicator.createIndicators(3,0)
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