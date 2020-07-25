package com.example.customviewassignment.mvp.presenter

import com.example.customviewassignment.delegates.ProfileItemDelegate
import com.example.customviewassignment.mvp.view.TaskView

interface TaskPresenter : BasePresenter<TaskView>,ProfileItemDelegate {
    fun onUIReady()
}