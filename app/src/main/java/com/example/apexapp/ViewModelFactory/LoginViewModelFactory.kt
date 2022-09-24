package com.example.apexapp.ViewModelFactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.apexapp.Repository.LoginRepo
import com.example.apexapp.ViewModel.LoginViewModel

class LoginViewModelFactory (private  val  repository : LoginRepo) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return  LoginViewModel(repository) as T
    }

}