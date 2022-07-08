package com.cuongpq.basemvvm.di.builder

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.cuongpq.basemvvm.di.model.ViewModelFactory
import com.cuongpq.basemvvm.di.model.ViewModelKey
import com.cuongpq.basemvvm.ui.main.MainViewModel
import com.cuongpq.basemvvm.ui.main.activity.login.LoginViewModel
import com.cuongpq.basemvvm.ui.main.activity.slash.SlashViewModel
import com.cuongpq.basemvvm.ui.main.fragment.favorite.FavoriteViewModel
import com.cuongpq.basemvvm.ui.main.fragment.home.HomeViewModel
import com.cuongpq.basemvvm.ui.main.fragment.notification.NotificationViewModel
import com.cuongpq.basemvvm.ui.main.fragment.profile.ProfileViewModel
import com.cuongpq.basemvvm.ui.main.fragment.signin.SigninViewModel
import com.cuongpq.basemvvm.ui.main.fragment.signup.SignupViewModel
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
    @IntoMap
    @ViewModelKey(SigninViewModel::class)
    abstract fun bindsSigninViewModel(signinViewModel: SigninViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SignupViewModel::class)
    abstract fun bindsSignupViewModel(signupViewModel: SignupViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindsHomeSViewModel(homeViewModel: HomeViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(FavoriteViewModel::class)
    abstract fun bindsFavoriteViewModel(favoriteViewModel: FavoriteViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(NotificationViewModel::class)
    abstract fun bindsNotificationViewModel(notificationViewModel: NotificationViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ProfileViewModel::class)
    abstract fun bindsProfileViewModel(profileViewModel: ProfileViewModel) : ViewModel

    @Binds
    abstract fun bindsViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory
}