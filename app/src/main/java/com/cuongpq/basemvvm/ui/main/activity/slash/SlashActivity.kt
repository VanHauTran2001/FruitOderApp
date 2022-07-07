package com.cuongpq.basemvvm.ui.main.activity.slash

import com.cuongpq.basemvvm.R
import com.cuongpq.basemvvm.databinding.ActivitySlashBinding
import com.cuongpq.basemvvm.ui.base.activity.BaseMVVMActivity
import com.cuongpq.basemvvm.ui.utils.OpenFragmentUtils

class SlashActivity : BaseMVVMActivity<SlashCallBack,SlashViewModel>(),SlashCallBack {
    override fun error(id: String, error: Throwable) {
       showMessage(error.message!!)
    }


    override fun getLayoutMain() = R.layout.activity_slash

    override fun setEvents() {
    }

    override fun initComponents() {
        getBindingData().slashViewModel = mModel
        OpenFragmentUtils.openUserFragment(supportFragmentManager)
    }

    override fun getBindingData() = mBinding as ActivitySlashBinding

    override fun getViewModel(): Class<SlashViewModel> {
        return SlashViewModel::class.java
    }
}