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
import com.example.openinappdemo.adapter.tabLayout.TopLinkAdapter
import com.example.openinappdemo.databinding.FragmentTopLinkBinding
import com.example.openinappdemo.ui.viewModel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TopLinkFragment : Fragment() {
    lateinit var binding : FragmentTopLinkBinding
    lateinit var mainViewMdoel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_top_link,container,false)
        mainViewMdoel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding.lifecycleOwner = this
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainViewMdoel.usersLiveData.observe(viewLifecycleOwner, Observer {
            binding.recyclerTopLink.apply {
                adapter = TopLinkAdapter(it.data.top_links)
                layoutManager = LinearLayoutManager(context)
            }
        })
    }

}