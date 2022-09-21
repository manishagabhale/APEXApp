package com.example.apexapp.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.apexapp.R
import com.example.rajpathbookreaderapp.ConstantAPI.PermissionAPI

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val permissions: PermissionAPI = PermissionAPI.getInstance(this)!!
        permissions.permissionsCheck()
    }
}