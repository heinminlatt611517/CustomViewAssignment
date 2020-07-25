package com.example.customviewassignment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.customviewassignment.R
import com.example.customviewassignment.views.viewholders.BaseVIewHolder
import com.example.customviewassignment.views.viewholders.TaskViewHolder

class TaskRecyclerAdapter : BaseRecyclerAdapter<BaseVIewHolder<Int>, Int>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseVIewHolder<Int> {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return TaskViewHolder(view)
    }
}