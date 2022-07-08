package com.cuongpq.basemvvm.ui.main.fragment.signin

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.text.InputType
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import com.cuongpq.basemvvm.R
import com.cuongpq.basemvvm.databinding.FragmentSigninBinding
import com.cuongpq.basemvvm.ui.base.fragment.BaseMvvmFragment
import com.cuongpq.basemvvm.ui.base.viewmodel.BaseViewModel
import com.cuongpq.basemvvm.ui.main.MainActivity

class SigninFragment : BaseMvvmFragment<SignInCallBack,SigninViewModel>(),SignInCallBack {
    private var sharedPreferences : SharedPreferences?=null
    private var passwordNotVisible = 1
    override fun error(id: String, error: Throwable) {
        showMessage(error.message!!)
    }

    override fun getLayoutMain() = R.layout.fragment_signin

    override fun setEvents() {

    }

    override fun initComponents() {
        getBindingData().signinViewModel = mModel
        sharedPreferences = activity?.getSharedPreferences("login",Context.MODE_PRIVATE)
        getBindingData().edtEmail.setText(sharedPreferences!!.getString("email",""))
        getBindingData().edtPassword.setText(sharedPreferences!!.getString("password",""))
        getBindingData().checkPass.isChecked = sharedPreferences!!.getBoolean("checked",false)
        mModel.uiEventLiveData.observe(this){
            when(it){
                BaseViewModel.FINISH_ACTIVITY -> finishActivity()
                SigninViewModel.START_SIGNIN -> startSignIn()
                SigninViewModel.VISIBLE_PASSWORD -> onClickVisible()
            }
        }
    }

    private fun onClickVisible() {
        if(passwordNotVisible==1){
            getBindingData().imgCheckPass.setImageResource(R.drawable.ic_baseline_visibility_off_24)
            getBindingData().edtPassword.transformationMethod = HideReturnsTransformationMethod.getInstance()
            passwordNotVisible = 0
        }else{
            getBindingData().imgCheckPass.setImageResource(R.drawable.ic_baseline_visibility_24 )
            getBindingData().edtPassword.transformationMethod = PasswordTransformationMethod.getInstance()
            passwordNotVisible = 1
        }
        getBindingData().edtPassword.setSelection(getBindingData().edtPassword.length())
    }

    private fun startSignIn() {
        onSaveUser()
        val intent = Intent(activity,MainActivity::class.java)
        activity?.startActivity(intent)

    }

    private fun onSaveUser() {
        if(getBindingData().checkPass.isChecked){
            val editor : SharedPreferences.Editor = sharedPreferences!!.edit()
            editor.putString("email",getBindingData().edtEmail.text.toString())
            editor.putString("password",getBindingData().edtPassword.text.toString())
            editor.putBoolean("checked",true)
            editor.commit()
        }else{
            val editor : SharedPreferences.Editor = sharedPreferences!!.edit()
            editor.remove("email")
            editor.remove("password")
            editor.remove("checked")
            editor.commit()
        }
    }

    override fun getBindingData() = mBinding as FragmentSigninBinding

    override fun getViewModel(): Class<SigninViewModel> {
        return SigninViewModel::class.java
    }

}