package com.example.kindkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_pager.*

class PagerActivity : AppCompatActivity() {

   lateinit var customPagerAdapter: PagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pager)
        setup()
    }

    private fun setup() {
        tabLayout.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab?.let {
                    when(it.id) {
                        R.id.oneTab -> { viewPager.currentItem = 0 }
                        R.id.twoTab -> { viewPager.currentItem = 1 }
                        R.id.threeTab -> { viewPager.currentItem = 2 }
                    }
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) { }

            override fun onTabReselected(tab: TabLayout.Tab?) { }
        })

        customPagerAdapter = CustomPagerAdapter()
        viewPager.adapter = customPagerAdapter
        tabLayout.setupWithViewPager(viewPager)
    }

    inner class CustomPagerAdapter: PagerAdapter() {
        private val list = listOf("One", "Two", "Three")

        override fun getCount(): Int = list.size

        override fun getPageTitle(position: Int): CharSequence = list[position]

        override fun isViewFromObject(view: View, `object`: Any): Boolean {
            return view == `object`
        }

        override fun instantiateItem(container: ViewGroup, position: Int): Any {
            val view = LayoutInflater.from(container.context).inflate(R.layout.pager_item, container, false)
            view.findViewById<TextView>(R.id.textView).text = list[position]
            container.addView(view)
            return view
        }

        override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
            container.removeView(`object` as View)
        }

    }
}