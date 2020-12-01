package com.coding.motivation

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.coding.motivation.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {

    private val binding by lazy { ActivitySplashBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        if (supportActionBar != null)
            supportActionBar!!.hide()

        binding.buttonSave.setOnClickListener {
            Log.v("Motivation","${binding.editName.text}")
            handleSave()
        }
    }

    private fun handleSave() {

        val name = binding.editName.text.toString()

        if(name != "")
            startActivity(Intent(this, MainActivity::class.java))
        else
            Toast.makeText(this,"Insira o seu nome!", Toast.LENGTH_SHORT).show()
    }
}