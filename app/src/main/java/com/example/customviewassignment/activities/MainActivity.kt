package com.example.customviewassignment.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.customviewassignment.R
import com.example.customviewassignment.adapter.ProfileImageAdapter
import com.example.customviewassignment.adapter.TaskRecyclerAdapter
import com.example.customviewassignment.views.itemDecoration.HorizontalOverlapDecoration
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val TOTAL_TIME = 8 * 1000L

    private lateinit var mTaskAdapter : TaskRecyclerAdapter
    private lateinit var mProfileAdapter : ProfileImageAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //timeOutRemoveTimer.start()
        circle_progress.progress = 0.8f

        setUpPresenter()
        setUpTaskRecyclerView()
        setUpProfileRecyclerView()
    }

    private fun setUpProfileRecyclerView(){
        mProfileAdapter= ProfileImageAdapter()
        val linearLayoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        rvProfile.layoutManager=linearLayoutManager
        rvProfile.addItemDecoration(HorizontalOverlapDecoration())
        rvProfile.adapter=mProfileAdapter

        mProfileAdapter.setNewData(mutableListOf(1,2,3,4,5))
    }

    private fun setUpTaskRecyclerView() {
        mTaskAdapter= TaskRecyclerAdapter()
        val linearLayoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        rv_task.layoutManager=linearLayoutManager
        rv_task.adapter=mTaskAdapter

        mTaskAdapter.setNewData(mutableListOf(1,2,3,4,5))
    }

    private fun setUpPresenter() {

    }

    private var timeOutRemoveTimer = object : CountDownTimer(TOTAL_TIME, 8) {
        override fun onFinish() {
            circle_progress.progress = 0.8f

        }

        override fun onTick(millisUntilFinished: Long) {
            circle_progress.progress = (TOTAL_TIME - millisUntilFinished).toFloat() / TOTAL_TIME
        }
    }
}
