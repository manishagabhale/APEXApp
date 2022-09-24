package com.example.apexapp.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import com.example.apexapp.R
import com.example.apexapp.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    var binding : ActivitySignUpBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        val view : View = binding!!.root
        setContentView(view)
    }
}