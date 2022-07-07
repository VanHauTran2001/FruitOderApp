package com.cuongpq.basemvvm.di.builder

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.cuongpq.basemvvm.di.model.ViewModelFactory
import com.cuongpq.basemvvm.di.model.ViewModelKey
import com.cuongpq.basemvvm.ui.main.MainViewModel
import com.cuongpq.basemvvm.ui.main.activity.login.LoginViewModel
import com.cuongpq.basemvvm.ui.main.activity.slash.SlashViewModel
import com.cuongpq.basemvvm.ui.main.user.UserViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
//******************************
//******************************
//***** Create by cuongpq  *****
//******************************
//******************************

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindsMainViewModel(mainViewModel: MainViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SlashViewModel::class)
    abstract fun bindsSlashViewModel(slashViewModel: SlashViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    abstract fun bindsLoginViewModel(loginViewModel: LoginViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(UserViewModel::class)
    abstract fun bindsUserViewModel(userViewModel: UserViewModel): ViewModel

    @Binds
    abstract fun bindsViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory
}