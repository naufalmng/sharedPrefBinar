package com.app.sharedpreferences

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.app.Constant
import com.app.SharedPreferencesHelper
import com.app.sharedpreferences.databinding.ActivityMainBinding
import com.app.sharedpreferences.ui.login.LoginActivity
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    lateinit var sharedPreferences: SharedPreferencesHelper


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        sharedPreferences = SharedPreferencesHelper(this)


        val usernameResult = sharedPreferences.getString(Constant.PREF_USERNAME)
        val passwordResult = sharedPreferences.getString(Constant.PREF_PASSWORD)
        binding.tvUsername.text = "USERNAME: $usernameResult"
        binding.tvPassword.text =  "PASSWORD: $passwordResult"

        binding.logoutBtn.setOnClickListener {
            sharedPreferences.clear()
            startActivity(Intent(this,LoginActivity::class.java))
            Toast.makeText(this, "Logout Berhasil", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finishAffinity()
        finish()
        exitProcess(0)
    }
}