package com.products.intelligent.androidkotlinseed.features.Users

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

import com.products.intelligent.androidkotlinseed.R

import javax.inject.Inject

import dagger.android.AndroidInjection

class LoginActivity : AppCompatActivity() {
    @set:Inject
    internal var loginViewModel: LoginViewModel? = null

    private var txtEmail: EditText? = null
    private var txtPassword: EditText? = null
    private var btnLogin: Button? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        setContentView(R.layout.activity_main)

        txtEmail = findViewById(R.id.txtEmailAddress)
        txtPassword = findViewById(R.id.txtPassword)

        btnLogin = findViewById(R.id.btnLogin)

        btnLogin!!.setOnClickListener {
            val email = txtEmail!!.text.toString().trim { it <= ' ' }
            val password = txtPassword!!.text.toString().trim { it <= ' ' }

            loginViewModel!!.email = email
            loginViewModel!!.password = password
            loginViewModel!!.onLoginClicked()
        }
    }
}
