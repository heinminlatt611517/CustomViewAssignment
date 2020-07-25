package com.example.customviewassignment.mvp.presenter

import androidx.lifecycle.ViewModel
import com.example.customviewassignment.mvp.view.BaseView

abstract class AbstractBasePresenter<T : BaseView> : BasePresenter<T>, ViewModel(){
    var mView : T? = null
    override fun initPresenter(view: T) {
        mView = view
    }
}