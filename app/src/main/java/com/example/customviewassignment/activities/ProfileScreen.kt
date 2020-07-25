package com.example.customviewassignment.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import com.example.customviewassignment.R
import com.example.customviewassignment.adapter.TabPagerAdapter
import com.example.customviewassignment.mvp.presenter.ProfilePresenter
import com.example.customviewassignment.mvp.presenter.ProfilePresenterImpl
import com.example.customviewassignment.mvp.view.ProfileView
import com.example.customviewassignment.views.viewpods.ProfileReactionViewPods
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_profile_screen.*

class ProfileScreen : BaseActivity(),ProfileView {

    private lateinit var mPresenter : ProfilePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_screen)

        setUpPresenter()
        setUpReactionViewPod()

        val pagerAdapter = TabPagerAdapter(this)
        viewPager.adapter=pagerAdapter
        TabLayoutMediator(tabLayout,viewPager) { tab, position ->
            when (position) {
                0 -> tab.text = "Project Tasks"
                1 -> tab.text = "Contacts"
                2 -> tab.text="About You"
            }
        }.attach()

    }

    private fun setUpPresenter() {
       mPresenter=ViewModelProviders.of(this).get(ProfilePresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    private fun setUpReactionViewPod() {
        val mReactionViewPods = profileReactionViewPod as ProfileReactionViewPods
        mReactionViewPods.setDelegate(mPresenter)
    }

    override fun onTapshare() {
        Toast.makeText(this,"Click Share",Toast.LENGTH_SHORT).show()
    }

    override fun onTapmessage() {
        Toast.makeText(this,"Click Message",Toast.LENGTH_SHORT).show()
    }

    override fun onTapAssign() {
        Toast.makeText(this,"Click Assign",Toast.LENGTH_SHORT).show()
    }

    override fun showErrorMessage(message: String) {

    }
}
