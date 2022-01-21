package com.example.examencoppel.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProviders
import com.example.examencoppel.databinding.ActivityMainBinding
import android.R
import android.app.PendingIntent.getActivity
import android.content.Context
import android.content.Intent
import android.view.View
import androidx.fragment.app.FragmentManager
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    //lateinit var loginViewModel: MVVMHeroe

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }


}