package com.example.demowechat

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.demowechat.model.User
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    lateinit var common_vars: CommonVariables
    lateinit var user: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        common_vars = application as CommonVariables
        user = common_vars.user!!

        val fcv_main = supportFragmentManager.findFragmentById(R.id.fcv_main) as NavHostFragment
        val bnv_main = findViewById<BottomNavigationView>(R.id.bnv_main)
        bnv_main.setupWithNavController(fcv_main.navController)
    }
}