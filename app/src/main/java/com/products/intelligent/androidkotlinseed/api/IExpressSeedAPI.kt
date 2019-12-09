package com.products.intelligent.androidkotlinseed.api

import com.products.intelligent.androidkotlinseed.features.Users.LoginModel
import com.products.intelligent.androidkotlinseed.features.Users.SessionModel
import com.products.intelligent.androidkotlinseed.features.Users.UserModel

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface IExpressSeedAPI {

    @GET("/users/")
    fun getUser(_id: Int): Call<UserModel>

    @POST("/users/")
    fun postUser(@Body user: UserModel): Call<UserModel>

    @POST("users/login")
    fun login(@Body user: LoginModel): Call<SessionModel>
}
