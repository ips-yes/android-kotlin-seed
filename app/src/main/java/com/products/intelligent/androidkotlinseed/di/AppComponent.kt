package com.products.intelligent.androidkotlinseed.di

import android.app.Application

import com.products.intelligent.androidkotlinseed.AndroidSeedApplication

import javax.inject.Singleton

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector

@Singleton
@Component(modules = [AndroidInjectionModule::class, AppModule::class, ActivityBuilder::class])
interface AppComponent : AndroidInjector<AndroidSeedApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }


    override fun inject(application: AndroidSeedApplication)

}
