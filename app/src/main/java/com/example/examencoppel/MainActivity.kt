package com.example.examencoppel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProviders
import com.example.examencoppel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    lateinit var loginViewModel: MVVMHeroe

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loginViewModel = ViewModelProviders.of(this).get(MVVMHeroe::class.java)
        startRequest()
    }

    fun startRequest(){
        if(ValidarR.hayRed(this)){
            loginViewModel.requestsHeroes()
        } else {
            val builder =  AlertDialog.Builder(this)
            builder.setMessage("No hay red")
            builder.setPositiveButton("ok"){ dialog, id-> }
            builder.show()
        }

    }
}