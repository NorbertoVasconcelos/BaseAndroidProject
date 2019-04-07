package com.josenobre.entertainmentapp.di

import android.app.Application
import com.josenobre.entertainmentapp.App
import com.josenobre.entertainmentapp.di.module.ActivityBuilderModule
import com.josenobre.entertainmentapp.di.module.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ActivityBuilderModule::class,
        ViewModelModule::class
    ]
)
interface AppComponent : AndroidInjector<App> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent

    }

    override fun inject(app: App)

}