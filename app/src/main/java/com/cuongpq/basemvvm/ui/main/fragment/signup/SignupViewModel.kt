package com.cuongpq.basemvvm.ui.main.fragment.signup

import com.cuongpq.basemvvm.data.local.AppDatabase
import com.cuongpq.basemvvm.data.remote.InteractCommon
import com.cuongpq.basemvvm.ui.base.viewmodel.BaseViewModel
import com.cuongpq.basemvvm.ui.main.repository.AuthenticationRepository
import java.util.concurrent.Executor
import javax.inject.Inject


class SignupViewModel @Inject constructor(
    appDatabase: AppDatabase,
    interactCommon: InteractCommon,
    scheduler: Executor
) : BaseViewModel<SignupCallBack>(appDatabase,interactCommon,scheduler){
    private var repository : AuthenticationRepository?=null

    companion object{
        const val START_SIGNUP = 1004
    }
    fun onSignup(email : String , password : String){
        uiEventLiveData.value= START_SIGNUP
        repository!!.onregister(email,password)
    }
}