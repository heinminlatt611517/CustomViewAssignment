package com.example.customviewassignment.views.viewholders

import android.view.View
import com.example.customviewassignment.delegates.ProfileItemDelegate

class ProfileViewHolder( private val mDelegate: ProfileItemDelegate,itemView: View) : BaseVIewHolder<Int>(itemView) {

    override fun bindData(data: Int) {
      mData = data
    }

    override fun onItemClick(data: Int) {
        mDelegate.onTapProfileItem()
    }
}