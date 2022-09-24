package com.example.apexapp.Activity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.apexapp.R
import com.example.apexapp.Repository.ForgotPassRepo
import com.example.apexapp.ViewModel.ForgotPassViewModel
import com.example.apexapp.ViewModelFactory.ForgotPassViewModelFactory
import com.example.apexapp.databinding.ActivityForgotPasswordBinding
import com.example.rajpathbookreaderapp.ConstantAPI.ApiClient
import com.example.rajpathbookreaderapp.ConstantAPI.ApiInterface

class ForgotPasswordActivity : AppCompatActivity() {
    var binding :ActivityForgotPasswordBinding? = null
    lateinit var forgotPassViewModel: ForgotPassViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForgotPasswordBinding.inflate(layoutInflater)
        val view : View = binding!!.root
        setContentView(view)

        val api = ApiClient.getInstance().create(ApiInterface::class.java)

        val repository = ForgotPassRepo(api)


        forgotPassViewModel = ViewModelProvider(this, ForgotPassViewModelFactory(repository)).get(
            ForgotPassViewModel::class.java
        )



        binding!!.btnOtpVerify.setOnClickListener {

            val user_email = binding!!.txtUserEmail.text.toString()

            forgotPassViewModel.forgotPassData(user_email)

            forgotPassViewModel.userPassData.observe(this, Observer {
                println("forgetPass" + it.message)
                if(it.status == 1){
                    Toast.makeText(this,"New password Send to Your Email ID",Toast.LENGTH_SHORT).show()
                    val intent = Intent(this,LoginActivity::class.java)
                    startActivity(intent)
                }
                else{
                    Toast.makeText(this,"Invalid Email ID",Toast.LENGTH_SHORT).show()
                }
            })

        }

    }
}