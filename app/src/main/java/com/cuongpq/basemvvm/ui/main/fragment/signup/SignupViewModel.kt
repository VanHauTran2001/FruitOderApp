package com.cuongpq.basemvvm.ui.main.fragment.signup

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.cuongpq.basemvvm.data.local.AppDatabase
import com.cuongpq.basemvvm.data.remote.InteractCommon
import com.cuongpq.basemvvm.ui.base.viewmodel.BaseViewModel
import com.cuongpq.basemvvm.ui.main.repository.AuthenticationRepository
import com.google.firebase.auth.FirebaseUser
import java.util.concurrent.Executor
import javax.inject.Inject


class SignupViewModel @Inject constructor(
    appDatabase: AppDatabase,
    interactCommon: InteractCommon,
    scheduler: Executor,
) : BaseViewModel<SignupCallBack>(appDatabase,interactCommon,scheduler){
    private var repository : AuthenticationRepository?=null
    private var userData: MutableLiveData<FirebaseUser>? = null
    private var application : Application = Application()

    companion object {
        const val START_SIGNUP = 1004
    }
    init {
        repository = AuthenticationRepository(application)
        userData = repository!!.getFirebaseUserMutableLiveData()
    }

    fun onSignup(email : String ,user:String, password : String,confirmPassword:String,phone : String){
//        uiEventLiveData.value= START_SIGNUP

        repository!!.onregister(email,user,password,confirmPassword,phone)
    }


}