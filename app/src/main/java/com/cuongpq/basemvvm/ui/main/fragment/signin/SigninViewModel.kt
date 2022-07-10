package com.cuongpq.basemvvm.ui.main.fragment.signin

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.cuongpq.basemvvm.data.local.AppDatabase
import com.cuongpq.basemvvm.data.remote.InteractCommon
import com.cuongpq.basemvvm.ui.base.viewmodel.BaseViewModel
import com.cuongpq.basemvvm.ui.main.repository.AuthenticationRepository
import com.google.firebase.auth.FirebaseUser
import java.util.concurrent.Executor
import javax.inject.Inject

class SigninViewModel @Inject constructor(
    appDatabase: AppDatabase,
    interactCommon: InteractCommon,
    scheduler: Executor
) : BaseViewModel<SignInCallBack>(appDatabase,interactCommon,scheduler){
    private var repository : AuthenticationRepository?=null
    private var userData: MutableLiveData<FirebaseUser>? = null
    private var application : Application?=null
    companion object{
        const val START_SIGNIN = 1003
        const val VISIBLE_PASSWORD = 1005
    }

    fun onSignin(email : String , password : String){
//        uiEventLiveData.value= START_SIGNIN
        repository = AuthenticationRepository(application)
        userData = repository!!.getFirebaseUserMutableLiveData()
        repository!!.onsignin(email,password)
    }
    fun onClickVisible(){
        uiEventLiveData.value = VISIBLE_PASSWORD
    }

}