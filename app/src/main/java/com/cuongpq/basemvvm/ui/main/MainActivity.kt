package com.cuongpq.basemvvm.ui.main

import androidx.fragment.app.Fragment
import com.cuongpq.basemvvm.R
import com.cuongpq.basemvvm.databinding.ActivityMainBinding
import com.cuongpq.basemvvm.ui.base.activity.BaseMVVMActivity
import com.cuongpq.basemvvm.ui.main.fragment.favorite.FavoriteFragment
import com.cuongpq.basemvvm.ui.main.fragment.home.HomeFragment
import com.cuongpq.basemvvm.ui.main.fragment.notification.NotificationFragment
import com.cuongpq.basemvvm.ui.main.fragment.profile.ProfileFragment

class MainActivity : BaseMVVMActivity<MainCallBack, MainViewModel>(), MainCallBack {

    override fun getLayoutMain() = R.layout.activity_main

    override fun setEvents() {
    }

    override fun initComponents() {
        getBindingData().viewModel = mModel
        replaceFragment(HomeFragment())
        onClickMenuItem()
    }
    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.content, fragment, Fragment::class.java.name)
            .commit()
    }
    private fun onClickMenuItem() {
        getBindingData().bottomNavigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.bottom_home -> {
                    replaceFragment(HomeFragment())
                    getBindingData().bottomNavigation.menu.findItem(R.id.bottom_home).isChecked = true
                }
                R.id.bottom_favorite -> {
                    replaceFragment(FavoriteFragment())
                    getBindingData().bottomNavigation.menu.findItem(R.id.bottom_favorite).isChecked = true
                }
                R.id.bottom_notifications -> {
                    replaceFragment(NotificationFragment())
                    getBindingData().bottomNavigation.menu.findItem(R.id.bottom_notifications).isChecked = true
                }
                R.id.bottom_profile -> {
                    replaceFragment(ProfileFragment())
                    getBindingData().bottomNavigation.menu.findItem(R.id.bottom_profile).isChecked = true
                }
            }
            false
        }
    }
    override fun getViewModel(): Class<MainViewModel> {
        return MainViewModel::class.java
    }

    override fun error(id: String, error: Throwable) {
        showMessage(error.message!!)
    }

    override fun getBindingData() = mBinding as ActivityMainBinding

}