package com.omelhordobrasil.kotlinbr.tamojunto.lucao.jokenpoapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.material.snackbar.Snackbar
import com.omelhordobrasil.kotlinbr.tamojunto.lucao.jokenpoapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        val toolbar = binding.toolbar

        setContentView(binding.root)
        setSupportActionBar(toolbar)

        supportActionBar?.title  = "novo titulo pela activity"
        supportActionBar?.setLogo(R.drawable.ic_logo)
        supportActionBar?.setDisplayUseLogoEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val activity2Intent = Intent(this, MainActivity2::class.java)
        intent.putExtra("name","tomaz")
        intent.putExtra("name",38)

        binding.startActivityButton.setOnClickListener {
            startActivity(activity2Intent)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}