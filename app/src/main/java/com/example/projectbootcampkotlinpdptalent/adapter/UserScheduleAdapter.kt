package com.example.projectbootcampkotlinpdptalent.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.projectbootcampkotlinpdptalent.R
import com.example.projectbootcampkotlinpdptalent.model.UserSchedule

class UserScheduleAdapter(private val scheduleList: List<UserSchedule>) :
    RecyclerView.Adapter<UserScheduleAdapter.ScheduleViewHolder>() {

    inner class ScheduleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtProgramName: TextView = itemView.findViewById(R.id.txtProgramName)
        val txtGroupName: TextView = itemView.findViewById(R.id.txtGroupName)
        val txtDateStart: TextView = itemView.findViewById(R.id.txtDateStart)
        val txtDateEnd: TextView = itemView.findViewById(R.id.txtDateEnd)
        val txtDuration: TextView = itemView.findViewById(R.id.txtDuration)
        val txtUnitName: TextView = itemView.findViewById(R.id.txtUnitName)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScheduleViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_schedule, parent, false)
        return ScheduleViewHolder(view)
    }

    override fun getItemCount(): Int = scheduleList.size

    override fun onBindViewHolder(holder: ScheduleViewHolder, position: Int) {
        val schedule = scheduleList[position]
        holder.txtProgramName.text = schedule.programName
        holder.txtGroupName.text = schedule.groupName
        holder.txtDateStart.text = schedule.startDate
        holder.txtDateEnd.text = schedule.endDate
        if (schedule.unitName.isNullOrEmpty()) {
            holder.txtUnitName.visibility = View.GONE
            holder.itemView.findViewById<ImageView>(R.id.imageView5)
                .setBackgroundResource(R.drawable.bg_1)
        } else {
            holder.txtUnitName.visibility = View.VISIBLE
            holder.txtUnitName.text = "- ${schedule.unitName}"
            holder.itemView.findViewById<ImageView>(R.id.imageView5)
                .setBackgroundResource(R.drawable.bg_2)
        }
        holder.txtDuration.text = "(${schedule.duration} Hari)"
    }
}
