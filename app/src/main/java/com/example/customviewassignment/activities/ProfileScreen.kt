package com.example.customviewassignment.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.customviewassignment.R
import com.example.customviewassignment.adapter.TabPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_profile_screen.*

class ProfileScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_screen)


        val pagerAdapter = TabPagerAdapter(this)
        viewPager.adapter=pagerAdapter
        TabLayoutMediator(tabLayout,viewPager) { tab, position ->
            when (position) {
                0 -> tab.text = "Project Tasks"
                1 -> tab.text = "Contacts"
                2 -> tab.text="About You"
            }
        }.attach()

    }
}
