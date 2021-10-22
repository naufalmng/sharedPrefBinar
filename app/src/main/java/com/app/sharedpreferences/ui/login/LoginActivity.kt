package com.app.sharedpreferences.ui.login

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import com.app.Constant
import com.app.SharedPreferencesHelper
import com.app.sharedpreferences.MainActivity

import com.app.sharedpreferences.R
import com.app.sharedpreferences.databinding.ActivityLoginBinding
import kotlin.system.exitProcess

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    lateinit var sharedPreferencesHelper: SharedPreferencesHelper

    override fun onStart() {
        super.onStart()
        if(sharedPreferencesHelper.getBoolean(Constant.PREF_IS_LOGIN)){
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        sharedPreferencesHelper = SharedPreferencesHelper(this)

        binding.login.setOnClickListener {
            //save session
            if(binding.username.text.isNotEmpty() && binding.username.text.contains('@') && binding.username.text.contains('.') && binding.password.text.isNotEmpty()){
                sharedPreferencesHelper.put(Constant.PREF_USERNAME,binding.username.text.toString())
                sharedPreferencesHelper.put(Constant.PREF_PASSWORD,binding.password.text.toString())
                sharedPreferencesHelper.put(Constant.PREF_IS_LOGIN,true)
                startActivity(Intent(this,MainActivity::class.java))
                Toast.makeText(this, "Login Berhasil", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finishAffinity()
    }

}