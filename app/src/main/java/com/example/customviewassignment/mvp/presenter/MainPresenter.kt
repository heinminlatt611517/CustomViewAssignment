package com.example.customviewassignment.mvp.presenter

import androidx.lifecycle.LifecycleOwner
import com.example.customviewassignment.delegates.ProfileItemDelegate
import com.example.customviewassignment.mvp.view.MainView

interface MainPresenter : BasePresenter<MainView> , ProfileItemDelegate{
   fun onUIReady()
}