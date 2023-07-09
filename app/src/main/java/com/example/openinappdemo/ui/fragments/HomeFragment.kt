package com.example.openinappdemo.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.openinappdemo.R
import com.example.openinappdemo.adapter.chartManager.ChartAdapter
import com.example.openinappdemo.adapter.GreetingsSetup
import com.example.openinappdemo.adapter.tabLayout.TabManager
import com.example.openinappdemo.databinding.FragmentHomeBinding
import com.example.openinappdemo.models.User
import com.example.openinappdemo.ui.viewModel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private lateinit var chartAdapter: ChartAdapter
    private lateinit var tabManager : TabManager
    private lateinit var greetingsSetup: GreetingsSetup
    private lateinit var mainViewMdoel: MainViewModel
    private lateinit var binding : FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_home,container,false)
        mainViewMdoel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding.lifecycleOwner = this
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        greetingsSetup = GreetingsSetup(binding.greetingsId)
        greetingsSetup.setupGrettings()

        tabManager = TabManager(binding.tablayout,binding.viewpager2,childFragmentManager,lifecycle)

        mainViewMdoel.usersLiveData.observe(viewLifecycleOwner, Observer {
            updateUI(it)
            setUpChart(it)
        })
    }

    private fun setUpChart(it: User) {
        chartAdapter = ChartAdapter(it.data.overall_url_chart,binding.linechart,binding.monthDateItem,requireContext())

    }

    private fun updateUI(it: User) {
        binding.userName.text = it.support_whatsapp_number
        binding.totalClickId.text = it.today_clicks.toString()
        binding.sourcesId.text = it.top_source
        binding.locationId.text = it.top_location
        binding.bestTimeId.text = it.startTime
    }
}

