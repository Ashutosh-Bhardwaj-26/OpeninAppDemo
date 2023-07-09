package com.example.openinappdemo.adapter.tabLayout

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.openinappdemo.R
import com.example.openinappdemo.databinding.LinkItemBinding
import com.example.openinappdemo.models.RecentLinks

class RecentLinkAdapter(private val recentLinks : List<RecentLinks>) : RecyclerView.Adapter<RecentLinkAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: LinkItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(item : RecentLinks){
            binding.sampleLink.text = item.app.toString()
            binding.dateId.text = item.created_at.toString()
            binding.downSampleLinkId.text = item.smart_link.toString()
            binding.totalClicksId.text = item.total_clicks.toString()
            if(item.app == "amazon"){
                binding.imageId.setBackgroundResource(R.drawable.amazon)
            }
            if(item.app == "flipkart"){
                binding.imageId.setBackgroundResource(R.drawable.flipkart)
            }
            if(item.app == "nobroker"){
                binding.imageId.setBackgroundResource(R.drawable.nobroker)
            }
            if(item.app == "youtube"){
                binding.imageId.setBackgroundResource(R.drawable.youtube)
            }
            if(item.app == "dailyhunt"){
                binding.imageId.setBackgroundResource(R.drawable.dailyhunt)
            }
            if(item.app == "facebook"){
                binding.imageId.setBackgroundResource(R.drawable.facebook)
            }
        }
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val linkItemBinding = LinkItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false)
        return ViewHolder(linkItemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val link = recentLinks[position]
        holder.bind(link)
    }

    override fun getItemCount(): Int {
        return recentLinks.size
    }

}