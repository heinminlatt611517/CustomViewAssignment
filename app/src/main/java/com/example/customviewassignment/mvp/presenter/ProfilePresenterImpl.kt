package com.example.customviewassignment.mvp.presenter

import com.example.customviewassignment.mvp.view.ProfileView

class ProfilePresenterImpl : ProfilePresenter, AbstractBasePresenter<ProfileView>() {
    override fun OnUIReady() {

    }

    override fun onShare() {
        mView?.onTapshare()
    }

    override fun onMessage() {
        mView?.onTapmessage()
    }

    override fun onAssign() {
        mView?.onTapAssign()
    }
}