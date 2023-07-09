package com.example.openinappdemo.adapter.tabLayout

import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.widget.ViewPager2
import com.example.openinappdemo.adapter.FragmentPageAdapter
import com.google.android.material.tabs.TabLayout

class TabManager(tabLayout: TabLayout,viewPager: ViewPager2, childFragmentManager: FragmentManager, lifecycle: Lifecycle) {
    private var adapter: FragmentPageAdapter

    init{
        tabLayout.addTab(tabLayout.newTab().setText("Top Links"))
        tabLayout.addTab(tabLayout.newTab().setText("Recent Links"))
        adapter = FragmentPageAdapter(childFragmentManager,lifecycle)
        viewPager.adapter = adapter
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if(tab!=null){
                    viewPager.currentItem = tab.position
                }

            }
            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }
            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        })

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                tabLayout.selectTab(tabLayout.getTabAt(position))
            }
        })

    }
}