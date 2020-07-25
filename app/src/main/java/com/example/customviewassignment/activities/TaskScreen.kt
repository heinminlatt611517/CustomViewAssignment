package com.example.customviewassignment.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.customviewassignment.R
import com.example.customviewassignment.adapter.ProfileImageAdapter
import com.example.customviewassignment.mvp.presenter.TaskPresenter
import com.example.customviewassignment.mvp.presenter.TaskPresenterImpl
import com.example.customviewassignment.mvp.view.ProfileView
import com.example.customviewassignment.mvp.view.TaskView
import com.example.customviewassignment.views.itemDecoration.HorizontalOverlapDecoration
import kotlinx.android.synthetic.main.activity_task_screen.*

class TaskScreen : BaseActivity(),TaskView {

    private lateinit var mPresenter : TaskPresenter
    private lateinit var mAdapter : ProfileImageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_screen)

        setUpPresenter()
        setUpRecyclerView()

        mPresenter.onUIReady()
    }

    private fun setUpRecyclerView() {
        mAdapter= ProfileImageAdapter(mPresenter)
        val linearLayoutManager= LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        rv_Task.layoutManager=linearLayoutManager
        rv_Task.addItemDecoration(HorizontalOverlapDecoration())
        rv_Task.adapter=mAdapter
    }

    private fun setUpPresenter() {
        mPresenter=ViewModelProviders.of(this).get(TaskPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    override fun navigateToProfileDetail() {
       startActivity(Intent(this,ProfileScreen::class.java))
    }

    override fun showProfileList() {
       mAdapter.setNewData(mutableListOf(1,2,3))
    }

    override fun showErrorMessage(message: String) {

    }
}
