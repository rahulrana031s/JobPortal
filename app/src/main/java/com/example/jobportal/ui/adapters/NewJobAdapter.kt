package com.example.jobportal.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.example.jobportal.R
import com.example.jobportal.databinding.NewJobBinding
import com.example.jobportal.databinding.UpcomingSessionBinding
import com.example.jobportal.ui.models.JobPosting
import com.example.jobportal.ui.models.UpcomingSession

class NewJobAdapter (val context: Context, private val mList: List<JobPosting>
): RecyclerView.Adapter<NewJobAdapter.UpcomingViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UpcomingViewHolder {
        val binding = NewJobBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UpcomingViewHolder(binding)

    }

    override fun onBindViewHolder(holder: UpcomingViewHolder, position: Int) {
        with(mList[position]){
            holder.binding.tvName.text = role
            holder.binding.tvorg.text = organization_name
            holder.binding.tvtype.text = location
            holder.binding.tvTiming.text = date_posted
        }
    }

    override fun getItemCount(): Int {
       return mList.size
    }

    inner class UpcomingViewHolder(val binding: NewJobBinding) : RecyclerView.ViewHolder(binding.root)

}




