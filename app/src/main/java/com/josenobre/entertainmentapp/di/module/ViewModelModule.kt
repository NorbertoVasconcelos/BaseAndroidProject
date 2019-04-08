package com.josenobre.entertainmentapp.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.josenobre.entertainmentapp.di.ViewModelFactory
import com.josenobre.entertainmentapp.di.ViewModelKey
import com.josenobre.entertainmentapp.ui.activity.MainActivityViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindsViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MainActivityViewModel::class)
    abstract fun bindsMainActivityViewModel(mainActivityMeViewModel: MainActivityViewModel): ViewModel

}