package com.example.customviewassignment.mvp.presenter

import androidx.lifecycle.LifecycleOwner
import com.example.customviewassignment.mvp.view.BaseView

 interface BasePresenter<T : BaseView> {
    abstract fun initPresenter(view : T)
}