package com.josenobre.entertainmentapp.di.module

import com.josenobre.entertainmentapp.ui.activity.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector
    abstract fun contributesMainActivity(): MainActivity

}