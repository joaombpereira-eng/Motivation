package com.coding.motivation.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.coding.motivation.R
import com.coding.motivation.databinding.ActivityMainBinding
import com.coding.motivation.infra.MotivationConstants
import com.coding.motivation.infra.SecurityPreferences
import com.coding.motivation.repository.Mock

class MainActivity : AppCompatActivity() {
    private lateinit var mSecurityPreferences: SecurityPreferences
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private var mPhraseFilter: Int = MotivationConstants.PHRASEFILTER.ALL

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        if (supportActionBar != null)
            supportActionBar!!.hide()

        mSecurityPreferences = SecurityPreferences(this)
        binding.textName.text = mSecurityPreferences.getString(MotivationConstants.KEY.PERSON_NAME)

        binding.imageAll.setColorFilter(resources.getColor(R.color.teal_200)) //Lógica inicial de seleção
        handleNewPhrase()

        val listFilter = listOf(binding.imageAll.id, binding.imageHappy.id, binding.imageMorning.id)

        binding.buttonNewPhrase.setOnClickListener {
            handleNewPhrase()
        }

        binding.imageAll.setOnClickListener {
            handleFilter(listFilter[0])
        }

        binding.imageHappy.setOnClickListener {
            handleFilter(listFilter[1])
        }

        binding.imageMorning.setOnClickListener {
            handleFilter(listFilter[2])
        }
    }

    private fun handleNewPhrase() {
        binding.textPhrase.text = Mock().getPhrase(mPhraseFilter)
    }

    private fun handleFilter(id: Int) {
        binding.imageAll.setColorFilter(resources.getColor(R.color.white))
        binding.imageHappy.setColorFilter(resources.getColor(R.color.white))
        binding.imageMorning.setColorFilter(resources.getColor(R.color.white))

        when (id) {
            binding.imageAll.id -> {
                binding.imageAll.setColorFilter(resources.getColor(R.color.teal_200))
                mPhraseFilter = MotivationConstants.PHRASEFILTER.ALL
            }
            binding.imageHappy.id -> {
                binding.imageHappy.setColorFilter(resources.getColor(R.color.teal_200))
                mPhraseFilter = MotivationConstants.PHRASEFILTER.HAPPY
            }
            binding.imageMorning.id -> {
                binding.imageMorning.setColorFilter(resources.getColor(R.color.teal_200))
                mPhraseFilter = MotivationConstants.PHRASEFILTER.MORNING
            }
        }
    }
}