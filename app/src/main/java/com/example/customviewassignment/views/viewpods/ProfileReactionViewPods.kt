package com.example.customviewassignment.views.viewpods

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.view_pods_reaction_profile.view.*

class ProfileReactionViewPods @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {
    private var mDelegate: Delegate? = null

    override fun onFinishInflate() {
        super.onFinishInflate()
        setUpListener()
    }

    fun setDelegate(delegate: Delegate) {
        mDelegate = delegate
    }

    private fun setUpListener() {
        ivShare.setOnClickListener {
            mDelegate?.onShare()
        }

        btnMessage.setOnClickListener {
            mDelegate?.onMessage()
        }

        ivAssignTask.setOnClickListener {
            mDelegate?.onAssign()
        }
    }

    interface Delegate{
        fun onShare()
        fun onMessage()
        fun onAssign()
    }
}