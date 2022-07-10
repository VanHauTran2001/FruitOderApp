package com.cuongpq.basemvvm.ui.main.fragment.signup

import android.app.Application
import android.text.TextUtils
import androidx.lifecycle.MutableLiveData
import com.cuongpq.basemvvm.data.local.AppDatabase
import com.cuongpq.basemvvm.data.remote.InteractCommon
import com.cuongpq.basemvvm.ui.base.viewmodel.BaseViewModel
import com.cuongpq.basemvvm.ui.main.repository.AuthenticationRepository
import com.google.firebase.auth.FirebaseAuth
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
    private var firebaseUserMutableLiveData: MutableLiveData<FirebaseUser>? = null
//    private var application : Application = Application()
    private var auth: FirebaseAuth?=null
    lateinit var emailAddress: String
    lateinit var username: String
    lateinit var password: String
    lateinit var confirmPassword: String
    lateinit var phoneNumber: String

    companion object {
        const val START_SIGNUP = 1004
        const val NAV_GET_DATA_FROM_UI_AND_REGISTER = 1005
        const val NAV_REGISTER_SUCCESS = 1006
        const val NAV_REGISTER_ERROR = 1007
    }
    init {
        auth = FirebaseAuth.getInstance()
        if (auth!!.currentUser != null) {
            firebaseUserMutableLiveData!!.postValue(auth!!.currentUser)
        }
//        repository = AuthenticationRepository(application)
//        userData = repository!!.getFirebaseUserMutableLiveData()
    }

    fun onSignup(){
        auth!!.createUserWithEmailAndPassword(emailAddress, password).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                uiEventLiveData.value = NAV_REGISTER_SUCCESS
            } else {
                uiEventLiveData.value = NAV_REGISTER_ERROR
            }
        }
    }
    fun performSignIn(){
        uiEventLiveData.value = NAV_GET_DATA_FROM_UI_AND_REGISTER
    }
}