package com.coding.motivation.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.coding.motivation.R
import com.coding.motivation.databinding.ActivityMainBinding
import com.coding.motivation.infra.MotivationConstants
import com.coding.motivation.infra.SecurityPreferences

class MainActivity : AppCompatActivity() {
    private lateinit var mSecurityPreferences: SecurityPreferences
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        mSecurityPreferences = SecurityPreferences(this)
        binding.textName.text = mSecurityPreferences.getString(MotivationConstants.KEY.PERSON_NAME)
    }
}