package com.example.customviewassignment.views.itemDecoration

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class HorizontalOverlapDecoration : RecyclerView.ItemDecoration() {
    private val horzontalOverlapCount = -20
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        outRect.set(0,0,horzontalOverlapCount,0)
    }
}