package com.cuongpq.basemvvm.ui.main.fragment.signin

import com.cuongpq.basemvvm.data.local.AppDatabase
import com.cuongpq.basemvvm.data.remote.InteractCommon
import com.cuongpq.basemvvm.ui.base.viewmodel.BaseViewModel
import java.util.concurrent.Executor
import javax.inject.Inject

class SigninViewModel @Inject constructor(
    appDatabase: AppDatabase,
    interactCommon: InteractCommon,
    scheduler: Executor
) : BaseViewModel<SignInCallBack>(appDatabase,interactCommon,scheduler){
    companion object{
        const val START_SIGNIN = 1003
        const val VISIBLE_PASSWORD = 1005
    }
    fun onSignin(){
        uiEventLiveData.value= START_SIGNIN
    }
    fun onClickVisible(){
        uiEventLiveData.value = VISIBLE_PASSWORD
    }

}