package com.products.intelligent.androidkotlinseed.di

import android.app.Application
import android.content.Context

import com.products.intelligent.androidkotlinseed.features.Users.LoginViewModel

import dagger.Module
import dagger.Provides

@Module
class AppModule {


    @Provides
    internal fun provideContext(application: Application): Context {
        return application
    }

    @Provides
    internal fun provideLoginViewmodel(application: Application): LoginViewModel {
        return LoginViewModel(application)
    }
}
