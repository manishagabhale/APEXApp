package com.example.apexapp.Repository
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.apexapp.Model.ForgotModel
import com.example.rajpathbookreaderapp.ConstantAPI.ApiInterface

class ForgotPassRepo (private val forgotPassData: ApiInterface) {

    private val liveData = MutableLiveData<ForgotModel>()
    val userData: LiveData<ForgotModel>
        get() = liveData

    suspend fun getResetData(userEmail: String) {

            val result = forgotPassData.resetPass(userEmail)
            if (result.body() != null) {
                if (result.isSuccessful)
                    liveData.postValue(result.body())
            }
        }


}