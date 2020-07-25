package com.example.customviewassignment.views.viewholders

import android.view.View
import com.example.customviewassignment.delegates.ProfileItemDelegate

class TaskOneViewHolder(itemView: View) : BaseVIewHolder<Int>(itemView) {
    override fun onItemClick(data: Int) {

    }

    override fun bindData(data: Int) {
      mData=data
    }
}