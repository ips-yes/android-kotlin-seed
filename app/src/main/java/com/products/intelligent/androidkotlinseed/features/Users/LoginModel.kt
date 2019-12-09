package com.products.intelligent.androidkotlinseed.features.Users

open class LoginModel {
    lateinit var username: String
    lateinit open var password: String

    constructor() {

    }

    constructor(username: String, password: String) {
        this.username = username
        this.password = password
    }
}
