package com.cuongpq.basemvvm.ui.main.fragment.signup

import android.widget.Toast
import com.cuongpq.basemvvm.R
import com.cuongpq.basemvvm.databinding.FragmentSignupBinding
import com.cuongpq.basemvvm.ui.base.fragment.BaseMvvmFragment
import com.cuongpq.basemvvm.ui.base.viewmodel.BaseViewModel
import com.cuongpq.basemvvm.ui.main.fragment.signin.SigninViewModel

class SignupFragment : BaseMvvmFragment<SignupCallBack,SignupViewModel>(),SignupCallBack{
    override fun error(id: String, error: Throwable) {
        showMessage(error.message!!)
    }

    override fun getLayoutMain() = R.layout.fragment_signup

    override fun setEvents() {

    }

    override fun initComponents() {
        getBindingData().signupViewModel = mModel
        mModel.uiEventLiveData.observe(this){
            when(it){
                BaseViewModel.FINISH_ACTIVITY -> finishActivity()
                SignupViewModel.START_SIGNUP -> startSignup()
            }
        }

    }

    private fun startSignup() {
       getBindingData().btnSignup.setOnClickListener {
           val email = getBindingData().edtEmail.text.toString().trim()
           val passwrod = getBindingData().edtPassword.text.toString().trim()
           if (email.isNotEmpty() && passwrod.isNotEmpty()){
               Toast.makeText(activity,"Register onsuccessfull",Toast.LENGTH_SHORT).show()
               mModel.onSignup(email,passwrod)
           }
       }
    }

    override fun getBindingData() = mBinding as FragmentSignupBinding

    override fun getViewModel(): Class<SignupViewModel> {
        return SignupViewModel::class.java
    }
}