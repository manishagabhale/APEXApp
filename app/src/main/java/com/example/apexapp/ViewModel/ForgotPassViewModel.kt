package com.example.apexapp.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apexapp.Model.ForgotModel
import com.example.apexapp.Repository.ForgotPassRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ForgotPassViewModel(private val repository : ForgotPassRepo) : ViewModel() {
    init {
        viewModelScope.launch(Dispatchers.IO) {
        }

    }

    val userPassData: LiveData<ForgotModel>
        get() = repository.userData



    fun forgotPassData(user_email: String) {

        viewModelScope.launch(Dispatchers.IO) {
            repository.getResetData(user_email)
        }

    }

}
