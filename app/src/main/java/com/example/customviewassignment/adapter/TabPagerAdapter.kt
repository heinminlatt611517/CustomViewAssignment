package com.example.customviewassignment.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.customviewassignment.fragments.FragmentOne
import com.example.customviewassignment.fragments.FragmentThree
import com.example.customviewassignment.fragments.FragmentTwo

class TabPagerAdapter (fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        when {
            position == 0 -> return FragmentOne()
            position == 1 -> return FragmentTwo()
            else -> return FragmentThree()
        }
    }
}