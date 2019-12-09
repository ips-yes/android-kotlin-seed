package com.products.intelligent.androidkotlinseed.di

import com.products.intelligent.androidkotlinseed.features.Users.LoginActivity

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {
    @ContributesAndroidInjector(modules = [AppModule::class])
    internal abstract fun bindLoginActivity(): LoginActivity
}
