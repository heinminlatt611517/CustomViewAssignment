package com.example.customviewassignment.mvp.presenter

import com.example.customviewassignment.delegates.ProfileReactionItemDelegate
import com.example.customviewassignment.mvp.view.ProfileView

interface ProfilePresenter :BasePresenter<ProfileView> , ProfileReactionItemDelegate {
    fun OnUIReady()
}