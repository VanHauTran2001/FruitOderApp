package com.cuongpq.basemvvm.ui.main.activity.slash

import android.content.Intent
import android.view.View
import com.cuongpq.basemvvm.data.local.AppDatabase
import com.cuongpq.basemvvm.data.remote.InteractCommon
import com.cuongpq.basemvvm.ui.base.viewmodel.BaseViewModel
import com.cuongpq.basemvvm.ui.main.activity.login.LoginActivity
import java.util.concurrent.Executor
import javax.inject.Inject

class SlashViewModel @Inject constructor(
    appDatabase: AppDatabase,
    interactCommon: InteractCommon,
    scheduler: Executor
) : BaseViewModel<SlashCallBack>(appDatabase,interactCommon,scheduler){

    fun onStart(view: View){
        val intent =Intent(view.context,LoginActivity::class.java)
        view.context.startActivity(intent)
    }
}