package com.cuongpq.basemvvm.ui.main.activity.login
import com.cuongpq.basemvvm.R
import com.cuongpq.basemvvm.databinding.ActivityLoginBinding
import com.cuongpq.basemvvm.ui.base.activity.BaseMVVMActivity
import com.cuongpq.basemvvm.ui.utils.OpenFragmentUtils

class LoginActivity :BaseMVVMActivity<LoginCallBack,LoginViewModel>(),LoginCallBack{
    override fun error(id: String, error: Throwable) {
        showMessage(error.message!!)
    }

    override fun getLayoutMain() = R.layout.activity_login

    override fun setEvents() {

    }

    override fun initComponents() {
        getBindingData().loginViewModel = mModel
    }

    override fun getBindingData() = mBinding as ActivityLoginBinding

    override fun getViewModel(): Class<LoginViewModel> {
        return LoginViewModel::class.java
    }
}