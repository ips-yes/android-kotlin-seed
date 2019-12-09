package com.products.intelligent.androidkotlinseed

import android.app.Activity
import android.app.Application

import com.products.intelligent.androidkotlinseed.utils.ReleaseTree
import com.products.intelligent.androidkotlinseed.BuildConfig
import com.products.intelligent.androidkotlinseed.api.ApiManager
import com.products.intelligent.androidkotlinseed.di.DaggerAppComponent

import javax.inject.Inject

import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import timber.log.Timber

class AndroidSeedApplication : Application(), HasActivityInjector {
    @set:Inject
    internal var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>? = null

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.builder()
                .application(this)
                .build()
                .inject(this)

        apiManager = ApiManager.getInstance(this.applicationContext)

        //Timber setup Debug mode will output to logcat
        if (BuildConfig.DEBUG) {
            Timber.plant(object : Timber.DebugTree() {
                //Add the line number to the tag
                override fun createStackElementTag(element: StackTraceElement): String? {
                    return super.createStackElementTag(element) + ": " + element.lineNumber
                }
            })
        } else {
            //Release mode will output to the location specified in utils/ReleaseTree.java
            Timber.plant(ReleaseTree())
        }

    }

    override fun activityInjector(): DispatchingAndroidInjector<Activity>? {
        return activityDispatchingAndroidInjector
    }

    companion object {

        lateinit var apiManager: ApiManager
    }
}
