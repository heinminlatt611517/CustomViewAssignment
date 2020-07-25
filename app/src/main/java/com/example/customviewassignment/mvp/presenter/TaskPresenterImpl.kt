package com.example.customviewassignment.mvp.presenter

import com.example.customviewassignment.mvp.view.TaskView

class TaskPresenterImpl : TaskPresenter, AbstractBasePresenter<TaskView>() {
    override fun onUIReady() {
        mView?.showProfileList()
    }

    override fun onTapProfileItem() {
        mView?.navigateToProfileDetail()
    }

    override fun onTapCreateTask() {

    }
}