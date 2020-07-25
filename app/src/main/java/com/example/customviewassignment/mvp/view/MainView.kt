package com.example.customviewassignment.mvp.view

interface MainView : BaseView {
    fun showTaskList()
    fun showProfileList()
    fun navigateToProfileDetail()
    fun navigateToCreateTaskActivity()
}