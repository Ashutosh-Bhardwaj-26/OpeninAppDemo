package com.example.openinappdemo.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.openinappdemo.R
import com.example.openinappdemo.adapter.tabLayout.RecentLinkAdapter
import com.example.openinappdemo.databinding.FragmentRecentLinkBinding
import com.example.openinappdemo.ui.viewModel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecentLinkFragment : Fragment() {
    lateinit var binding : FragmentRecentLinkBinding
    lateinit var mainViewMdoel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_recent_link,container,false)
        mainViewMdoel =ViewModelProvider(this).get(MainViewModel::class.java)
        binding.lifecycleOwner = this
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainViewMdoel.usersLiveData.observe(viewLifecycleOwner, Observer {
            binding.recyclerRecentLink.apply {
                adapter = RecentLinkAdapter(it.data.recent_links)
                layoutManager = LinearLayoutManager(context)
            }
        })
    }


}