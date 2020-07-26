package com.example.customviewassignment.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.customviewassignment.R
import com.example.customviewassignment.adapter.ProfileImageAdapter
import com.example.customviewassignment.adapter.TaskRecyclerAdapter
import com.example.customviewassignment.mvp.presenter.MainPresenter
import com.example.customviewassignment.mvp.presenter.MainPresenterImpls
import com.example.customviewassignment.mvp.view.MainView
import com.example.customviewassignment.views.itemDecoration.HorizontalOverlapDecoration
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() , MainView{

    val TOTAL_TIME = 8 * 1000L

    private lateinit var mTaskAdapter : TaskRecyclerAdapter
    private lateinit var mProfileAdapter : ProfileImageAdapter
    private lateinit var mPresenter : MainPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //timeOutRemoveTimer.start()


        setUpPresenter()
        setUpProgressBar()
        setUpTaskRecyclerView()
        setUpProfileRecyclerView()

        mPresenter.onUIReady()
    }

    private fun setUpProfileRecyclerView(){
        mProfileAdapter= ProfileImageAdapter(mPresenter)
        val linearLayoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        rvProfile.layoutManager=linearLayoutManager
        rvProfile.addItemDecoration(HorizontalOverlapDecoration())
        rvProfile.adapter=mProfileAdapter

    }

    private fun setUpTaskRecyclerView() {
        mTaskAdapter= TaskRecyclerAdapter()
        val linearLayoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        rv_task.layoutManager=linearLayoutManager
        rv_task.adapter=mTaskAdapter


    }

    private fun setUpProgressBar()
    {
        circle_progress.setProgressColor(getResources().getColor(R.color.colorPrimary));
        circle_progress.setProgressWidth(10)
        circle_progress.setProgress(75)
    }

    private fun setUpPresenter() {
        mPresenter=ViewModelProviders.of(this).get(MainPresenterImpls::class.java)
        mPresenter.initPresenter(this)

    }

//    private var timeOutRemoveTimer = object : CountDownTimer(TOTAL_TIME, 8) {
//        override fun onFinish() {
//            circle_progress.progress = 0.8f
//
//        }
//
//        override fun onTick(millisUntilFinished: Long) {
//            circle_progress.progress = (TOTAL_TIME - millisUntilFinished).toFloat() / TOTAL_TIME
//        }
//    }

    override fun showTaskList() {
        mTaskAdapter.setNewData(mutableListOf(1,2,3,4,5))
    }

    override fun showProfileList() {
        mProfileAdapter.setNewData(mutableListOf(1,2,3,4,5))
    }

    override fun navigateToProfileDetail() {
        startActivity(Intent(this,ProfileScreen::class.java))
    }

    override fun navigateToCreateTaskActivity() {
        startActivity(Intent(this,TaskScreen::class.java))
    }

    override fun showErrorMessage(message: String) {

    }
}
