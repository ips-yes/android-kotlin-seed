package com.products.intelligent.androidkotlinseed.features.Users

import com.products.intelligent.androidkotlinseed.AndroidSeedApplication

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber
import android.widget.Toast;
import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;

class LoginViewModel(application: Application) : AndroidViewModel(application) {


    lateinit var email: String
    lateinit var password: String

    fun onLoginClicked() {
        val user = LoginModel(email, password)
        AndroidSeedApplication.apiManager.login(user, object : Callback<SessionModel> {

            override fun onResponse(call: Call<SessionModel>, response: Response<SessionModel>) {
                Timber.v(response.message())

                showToast(response.isSuccessful())
            }

            override fun onFailure(call: Call<SessionModel>, t: Throwable) {
                Timber.w("Got Response Fail")

                showToast(false)
            }

            fun showToast(success: Boolean){

                val text = if (success) "Login Success" else "Login Failed"
                val duration = Toast.LENGTH_SHORT

                val toast = Toast.makeText(getApplication<Application>().getApplicationContext(), text, duration)
                toast.show()
            }
        })
    }

}
