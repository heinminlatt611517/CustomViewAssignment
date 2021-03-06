package com.example.customviewassignment.views.viewholders

import android.view.View
import com.example.customviewassignment.delegates.ProfileItemDelegate

class TaskViewHolder(private val mDelegate: ProfileItemDelegate,itemView: View) : BaseVIewHolder<Int>(itemView) {
    override fun onItemClick(data: Int) {
      mDelegate.onTapCreateTask()
    }

    override fun bindData(data: Int) {
      mData=data
    }
}