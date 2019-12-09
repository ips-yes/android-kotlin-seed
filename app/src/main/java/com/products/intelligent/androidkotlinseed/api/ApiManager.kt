package com.products.intelligent.androidkotlinseed.api

import android.app.Application
import android.content.Context

import com.products.intelligent.androidkotlinseed.features.Users.LoginModel
import com.products.intelligent.androidkotlinseed.features.Users.SessionModel
import com.products.intelligent.androidkotlinseed.features.Users.UserModel

import java.util.concurrent.TimeUnit

import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import android.content.pm.PackageManager
import android.os.Bundle
import android.content.pm.ApplicationInfo



class ApiManager private constructor(private val context: Context) {

    init {
        val okHttpClient = OkHttpClient().newBuilder()
                .connectTimeout((60 * 5).toLong(), TimeUnit.SECONDS)
                .readTimeout((60 * 5).toLong(), TimeUnit.SECONDS)
                .writeTimeout((60 * 5).toLong(), TimeUnit.SECONDS)

        okHttpClient.interceptors().add(ReceiveCookieInterceptor(context))

        val url = getMetaData(context, "api_url")

        val retrofit = Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient.build())
                .build()

        service = retrofit.create(IExpressSeedAPI::class.java!!)
    }

    fun getUser(_id: Int, callback: Callback<UserModel>) {
        val userCall = service.getUser(_id)
        userCall.enqueue(callback)
    }

    fun postUser(user: UserModel, callback: Callback<UserModel>) {
        val userCall = service.postUser(user)
        userCall.enqueue(callback)
    }

    fun login(user: LoginModel, callback: Callback<SessionModel>) {
        val loginCall = service.login(user)
        loginCall.enqueue(callback)
    }

    fun getMetaData(context: Context, name: String): String? {
        val ai = context.packageManager.getApplicationInfo(context.packageName, PackageManager.GET_META_DATA)
        val bundle = ai.metaData
        return bundle.getString(name)
    }

    companion object {
        lateinit private var service: IExpressSeedAPI
        private var apiManager: ApiManager? = null

        fun getInstance(context: Context): ApiManager {
            if (apiManager == null) {
                apiManager = ApiManager(context)
            }
            return apiManager as ApiManager
        }
    }

}
