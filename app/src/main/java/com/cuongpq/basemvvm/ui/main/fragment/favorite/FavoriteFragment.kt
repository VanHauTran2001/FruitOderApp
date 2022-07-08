package com.cuongpq.basemvvm.ui.main.fragment.favorite

import com.cuongpq.basemvvm.R
import com.cuongpq.basemvvm.databinding.FragmentFavoriteBinding
import com.cuongpq.basemvvm.ui.base.fragment.BaseMvvmFragment

class FavoriteFragment : BaseMvvmFragment<FavoriteCallBack, FavoriteViewModel>(), FavoriteCallBack {
    override fun error(id: String, error: Throwable) {
        showMessage(error.message!!)
    }

    override fun getLayoutMain() = R.layout.fragment_favorite

    override fun setEvents() {

    }

    override fun initComponents() {
        getBindingData().favoriteViewModel = mModel
    }


    override fun getBindingData() = mBinding as FragmentFavoriteBinding

    override fun getViewModel(): Class<FavoriteViewModel> {
        return FavoriteViewModel::class.java
    }
}
