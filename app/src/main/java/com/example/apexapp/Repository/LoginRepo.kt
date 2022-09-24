package com.example.apexapp.Repository

import android.content.Context
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.apexapp.Model.LoginModelX
import com.example.apexapp.R
import com.example.rajpathbookreaderapp.ConstantAPI.ApiInterface
import com.example.rajpathbookreaderapp.ConstantAPI.NetworkConnection

class LoginRepo(private val loginData: ApiInterface, private val applicationContext: Context) {

    private val loginLiveData = MutableLiveData<LoginModelX>()
    val userLoginData: LiveData<LoginModelX>
        get() = loginLiveData

   suspend fun getLoginData(userName: String, password: String) {
       if (NetworkConnection.isInternetAvailable(applicationContext)) {
           val result = loginData.userLogin(userName, password)
           if (result.body() != null) {
               if (result.isSuccessful)
                   loginLiveData.postValue(result.body())
           }
       }
       else{
           Handler(Looper.getMainLooper()).post {
               Toast.makeText(applicationContext,applicationContext.getString(R.string.please_check_internet_connection), Toast.LENGTH_SHORT).show()

           }
           }
    }
}