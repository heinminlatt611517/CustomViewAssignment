package com.example.customviewassignment.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.customviewassignment.R
import com.example.customviewassignment.delegates.ProfileItemDelegate
import com.example.customviewassignment.views.viewholders.BaseVIewHolder
import com.example.customviewassignment.views.viewholders.ProfileViewHolder
import com.example.customviewassignment.views.viewholders.TaskViewHolder
class ProfileImageAdapter(delegate : ProfileItemDelegate) : BaseRecyclerAdapter<BaseVIewHolder<Int>, Int>() {

    val mDelegate = delegate

    val VIEW_TYPE_PROFILE = 0
    val VIEW_TYPE_ADD = 1
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseVIewHolder<Int> {
        when (viewType) {
            VIEW_TYPE_PROFILE -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_profile, parent, false)
                return ProfileViewHolder(mDelegate,view)
            }
            VIEW_TYPE_ADD -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_add, parent, false)
                return TaskViewHolder(mDelegate,view)
            }

            else -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_profile, parent, false)
                return ProfileViewHolder(mDelegate,view)
            }
        }
    }
    override fun getItemViewType(position: Int): Int {
        mData+1
         when(position){
             mData.size-1-> {
                 return VIEW_TYPE_ADD
             }
             else ->{
                 return VIEW_TYPE_PROFILE
             }
         }

    }
}