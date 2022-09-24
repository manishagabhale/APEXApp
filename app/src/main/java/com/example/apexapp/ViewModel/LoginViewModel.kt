package com.example.apexapp.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apexapp.Model.LoginModelX
import com.example.apexapp.Repository.LoginRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginViewModel(private val repository: LoginRepo) : ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO) {
        }


    }

    val userLoginData: LiveData<LoginModelX>
        get() = repository.userLoginData



    fun loginData(username: String, password: String) {

        viewModelScope.launch(Dispatchers.IO) {
            repository.getLoginData(username, password)
        }

    }

}