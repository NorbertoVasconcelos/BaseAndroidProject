package com.josenobre.entertainmentapp.di.module

import com.josenobre.entertainmentapp.ui.mainscreen.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector
    abstract fun contributesMainActivity(): MainActivity

}