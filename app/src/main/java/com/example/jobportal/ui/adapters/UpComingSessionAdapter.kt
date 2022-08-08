package com.example.jobportal.ui.adapters

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.graphics.drawable.DrawableCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.jobportal.R
import com.example.jobportal.databinding.UpcomingSessionBinding
import com.example.jobportal.ui.models.UpcomingSession


class UpComingSessionAdapter (val context: Context,private val mList: List<UpcomingSession>
): RecyclerView.Adapter<UpComingSessionAdapter.UpcomingViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UpcomingViewHolder {
        val binding = UpcomingSessionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UpcomingViewHolder(binding)

    }


    override fun onBindViewHolder(holder: UpcomingViewHolder, position: Int) {
        with(mList[position]){
            holder.binding.tvName.text = mentor_name
            holder.binding.tvDate.text = date
            holder.binding.tvTime.text = timings
            holder.binding.tvtype.text = session_type
            setBg(holder.binding.tvtype)




        }
    }

    private fun setBg(tvtype: TextView) {

//        tvtype.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.rounded_button_two));

    }

    override fun getItemCount(): Int {
       return mList.size
    }

    inner class UpcomingViewHolder(val binding: UpcomingSessionBinding) : RecyclerView.ViewHolder(binding.root)

}




