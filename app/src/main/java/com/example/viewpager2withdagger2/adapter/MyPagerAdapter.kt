package com.example.viewpager2withdagger2.adapter

import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.viewpager2withdagger2.FirstFragment
import com.example.viewpager2withdagger2.SecondFragment
import javax.inject.Inject

class MyPagerAdapter @Inject constructor(fm: FragmentManager, lifeCycle: Lifecycle) :
    FragmentStateAdapter(
        fm,
        lifeCycle
    ) {


    override fun getItemCount() = 2

    override fun createFragment(position: Int) = when (position) {
        0 -> FirstFragment()
        1 -> SecondFragment()
        else -> FirstFragment()
        }
}