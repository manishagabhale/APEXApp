package com.example.apexapp.ViewModelFactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.apexapp.Repository.ForgotPassRepo
import com.example.apexapp.ViewModel.ForgotPassViewModel

class ForgotPassViewModelFactory (private  val  repository : ForgotPassRepo) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return  ForgotPassViewModel(repository) as T
    }

}