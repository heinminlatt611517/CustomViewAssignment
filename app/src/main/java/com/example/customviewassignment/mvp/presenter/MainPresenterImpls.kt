package com.example.customviewassignment.mvp.presenter

import androidx.lifecycle.LifecycleOwner
import com.example.customviewassignment.mvp.view.MainView

class MainPresenterImpls : MainPresenter,AbstractBasePresenter<MainView>() {
    override fun onUIReady() {
        mView?.showProfileList()
        mView?.showTaskList()
    }

    override fun onTapProfileItem() {
        mView?.navigateToProfileDetail()
    }

    override fun onTapCreateTask() {
        mView?.navigateToCreateTaskActivity()
    }


}