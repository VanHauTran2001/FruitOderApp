package com.cuongpq.basemvvm.ui.main.repository

import android.app.Application
import android.app.ProgressDialog
import android.content.Intent
import android.text.TextUtils
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.MutableLiveData
import com.cuongpq.basemvvm.ui.main.MainActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlin.coroutines.coroutineContext


class AuthenticationRepository{
    private var application : Application?=null
    private var firebaseUserMutableLiveData: MutableLiveData<FirebaseUser>? = null
    private var auth:FirebaseAuth?=null

    fun getFirebaseUserMutableLiveData(): MutableLiveData<FirebaseUser>? {
        return firebaseUserMutableLiveData
    }


    constructor(application: Application?) {
        this.application = application
        firebaseUserMutableLiveData = MutableLiveData()
        auth = FirebaseAuth.getInstance()
        if (auth!!.currentUser != null) {
            firebaseUserMutableLiveData!!.postValue(auth!!.currentUser)
        }
    }
    fun onregister(email : String ,user:String, password : String,confirmPassword:String,phone : String){
        when {
            TextUtils.isEmpty(email) -> {
                message("Email can not be empty !")
            }
            TextUtils.isEmpty(user) -> {
                message("User can not be empty !")
            }
            TextUtils.isEmpty(password) -> {
                message("Password can not be empty !")
            }
            TextUtils.isEmpty(confirmPassword) -> {
                message("Confirm Password can not be empty !")
            }
            TextUtils.isEmpty(phone) -> {
                message("Phone number can not be empty !")
            }
            password != confirmPassword ->{
                message("Password not true")
            }
            else -> {
//                val progressDialog = ProgressDialog(application)
//                progressDialog.setTitle("Register")
//                progressDialog.setMessage("Please wait.......")
//                progressDialog.setCanceledOnTouchOutside(false)
//                progressDialog.show()
                auth!!.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->
//                    progressDialog.dismiss()
                    if (task.isSuccessful) {
                        message("Register onsuccessfull !")
                        firebaseUserMutableLiveData!!.postValue(auth!!.currentUser)
                    } else {
                        message("Register fail !!!")
                    }
                }
            }
        }

    }
    fun onsignin(email: String,password: String){
        when {
            TextUtils.isEmpty(email) -> {
                message("Email can not be empty !")
            }
            TextUtils.isEmpty(password) -> {
                message("Password can not be empty !")
            }
            else -> {
//                val progressDialog = ProgressDialog(application)
//                progressDialog.setTitle("Login")
//                progressDialog.setMessage("Please wait.......")
//                progressDialog.setCanceledOnTouchOutside(false)
//                progressDialog.show()
                auth!!.signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->
//                    progressDialog.dismiss()
                    if (task.isSuccessful) {
                        message("Login onsuccessfull !")
                        firebaseUserMutableLiveData!!.postValue(auth!!.currentUser)
                        val intent = Intent(application, MainActivity::class.java)
                        application!!.startActivity(intent)
                    } else {
                        message("Login fail !")

                    }
                }
            }
        }

    }
    fun message(message : String){
        Toast.makeText(application,message, Toast.LENGTH_SHORT).show()
    }
}