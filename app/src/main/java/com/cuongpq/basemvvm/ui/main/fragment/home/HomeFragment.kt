package com.cuongpq.basemvvm.ui.main.fragment.home

import com.cuongpq.basemvvm.R
import com.cuongpq.basemvvm.databinding.FragmentHomeBinding
import com.cuongpq.basemvvm.ui.base.fragment.BaseMvvmFragment

class HomeFragment : BaseMvvmFragment<HomeCallBack, HomeViewModel>(), HomeCallBack {
    override fun error(id: String, error: Throwable) {
        showMessage(error.message!!)
    }

    override fun getLayoutMain() = R.layout.fragment_home

    override fun setEvents() {

    }

    override fun initComponents() {
        getBindingData().homeViewModel = mModel
    }


    override fun getBindingData() = mBinding as FragmentHomeBinding

    override fun getViewModel(): Class<HomeViewModel> {
        return HomeViewModel::class.java
    }
}