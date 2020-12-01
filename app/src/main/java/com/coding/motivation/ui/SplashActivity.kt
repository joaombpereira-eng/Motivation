package com.coding.motivation.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.coding.motivation.databinding.ActivitySplashBinding
import com.coding.motivation.infra.MotivationConstants
import com.coding.motivation.infra.SecurityPreferences

class SplashActivity : AppCompatActivity() {
    private val binding by lazy { ActivitySplashBinding.inflate(layoutInflater) }
    private lateinit var mSecurityPreferences: SecurityPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        mSecurityPreferences = SecurityPreferences(this)

        if (supportActionBar != null)
            supportActionBar!!.hide()

        binding.buttonSave.setOnClickListener {
            Log.v("Motivation", "${binding.editName.text}")
            handleSave()
        }

        verifyName()
    }

    private fun verifyName() {
        val name = mSecurityPreferences.getString(MotivationConstants.KEY.PERSON_NAME)
        if (name != "")
            startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    private fun handleSave() {
        val name = binding.editName.text.toString()

        if (name != "") {
            mSecurityPreferences.storeString(MotivationConstants.KEY.PERSON_NAME, name)
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        } else
            Toast.makeText(this, "Insira o seu nome!", Toast.LENGTH_SHORT).show()
    }
}