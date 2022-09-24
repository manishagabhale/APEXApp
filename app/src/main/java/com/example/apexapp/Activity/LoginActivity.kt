package com.example.apexapp.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.apexapp.ConstantAPI.PrefConfig
import com.example.apexapp.Repository.LoginRepo
import com.example.apexapp.ViewModel.LoginViewModel
import com.example.apexapp.ViewModelFactory.LoginViewModelFactory
import com.example.apexapp.databinding.ActivityLoginBinding
import com.example.rajpathbookreaderapp.ConstantAPI.*

class LoginActivity() : AppCompatActivity() {

    private var binding: ActivityLoginBinding? = null
    lateinit var loginViewModel: LoginViewModel
    lateinit var userId : String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view: View = binding!!.root
        setContentView(view)

        val permissions: PermissionAPI = PermissionAPI.getInstance(this)!!
        permissions.permissionsCheck()



        val api = ApiClient.getInstance().create(ApiInterface::class.java)
        val repository = LoginRepo(api,this)

        loginViewModel = ViewModelProvider(this, LoginViewModelFactory(repository)).get(
            LoginViewModel::class.java
        )


        binding!!.btnLogin.setOnClickListener{
        if (binding!!.checkBox2.isChecked) {
            val username = binding!!.email.text.toString().trim()
            val password = binding!!.password.text.toString().trim()

            loginViewModel.loginData(username, password)
        } else
            Toast.makeText(this,"Please accept Term and Conditions", Toast.LENGTH_SHORT).show()
         //  if( username.isValidEmail()) {
        //  if( username.isValidEmail()) {
        //  }
        //    else{
        //     Toast.makeText(this,"Please Enter Valid User Name", Toast.LENGTH_SHORT).show()
        // }

    }
        loginViewModel!!.userLoginData.observe(this, Observer {
            Log.d("Login", "Success" + "->" + it.status)
            userId = it.user[0].uid
            PrefConfig(this).writeUserId(userId)
            if (it.status == 0) {
                Toast.makeText(this, "Invalid Username or Password", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this,DashboardActivity::class.java)
                startActivity(intent)

            }

        })


        binding!!.forgetPassword.setOnClickListener {
            val intent = Intent(this,ForgotPasswordActivity::class.java)
            startActivity(intent)
        }

        binding!!.txtSingup.setOnClickListener {
            val intent = Intent(this,SignUpActivity::class.java)
            startActivity(intent)
        }
    }
    fun String.isValidEmail() = isNotEmpty() && android.util.Patterns.EMAIL_ADDRESS.matcher(this).matches()
}