package com.example.arrivalnotice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
//    private val navHostFragment: NavHostFragment =
//        supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
//
//    var navController = navHostFragment.navController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


//        navController = nav_host_fragment.findNavController()

    }
}