package com.app.sharedpreferences

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.app.sharedpreferences.databinding.ActivitySplashScreenBinding
import com.app.sharedpreferences.ui.login.LoginActivity

class SplashScreen : AppCompatActivity() {
    private lateinit var binding: ActivitySplashScreenBinding
//    private val sharedPreferences =

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        handler()
      }
    private fun handler(){
            Handler(Looper.getMainLooper()).postDelayed({
                startActivity(Intent(this,LoginActivity::class.java))
            },1500)
        }
}