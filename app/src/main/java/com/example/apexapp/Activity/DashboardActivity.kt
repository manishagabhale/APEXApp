package com.example.apexapp.Activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.apexapp.Activity.ui.home.HomeFragment
import com.example.apexapp.Fragment.ProfileFragment
import com.example.apexapp.Fragment.QuestionBankFragment
import com.example.apexapp.Fragment.TestFragment
import com.example.apexapp.Fragment.VideoFragment
import com.example.apexapp.R
import com.example.apexapp.databinding.ActivityDashboardBinding
import com.example.rajpathbookreaderapp.ConstantAPI.PermissionAPI
import com.google.android.material.bottomnavigation.BottomNavigationView

class DashboardActivity : AppCompatActivity() {


    private lateinit var binding: ActivityDashboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val permissions: PermissionAPI = PermissionAPI.getInstance(this)!!
        permissions.permissionsCheck()


        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        loadFragment( HomeFragment())

        bottomNav.setOnNavigationItemSelectedListener(BottomNavigationView.OnNavigationItemSelectedListener { item ->
            val fragment: Fragment? = null
            when (item.itemId) {
                R.id.menu_home -> {
                    loadFragment(HomeFragment())
                    return@OnNavigationItemSelectedListener true
                }
                R.id.menu_video -> {
                    loadFragment(VideoFragment())
                    return@OnNavigationItemSelectedListener true
                }
                R.id.menu_question_bank -> {
                    loadFragment(QuestionBankFragment())
                    return@OnNavigationItemSelectedListener true
                }
                R.id.menu_test -> {
                    loadFragment(TestFragment())
                    return@OnNavigationItemSelectedListener true
                }
                R.id.menu_profile -> {
                    loadFragment(ProfileFragment())
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        })

    }

    fun loadFragment(fragments: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.nav_host_container, fragments)
        fragmentTransaction.commit()
    }
}