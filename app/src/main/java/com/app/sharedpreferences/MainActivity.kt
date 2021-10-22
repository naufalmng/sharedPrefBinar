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
//    private val preferencesEditor: SharedPreferencesHelper.Editor by lazy{
//        sharedPreferences.edit()
//    }
//override fun onStart() {
//    super.onStart()
//    if(sharedPreferences.getBoolean(Constant.PREF_IS_LOGIN)){
//        startActivity(Intent(this, MainActivity::class.java))
//        finish()
//    }
//}

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        sharedPreferences = SharedPreferencesHelper(this)
//        val preferencesEditor = sharedPreferences.edit()

//        binding.etValue.setOnClickListener {
//            val textValue = binding.etValue.text.toString()
//            preferencesEditor.putString("Value",textValue)
//            preferencesEditor.apply()
//        }
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
//private var _binding: ? = null
//private val binding get() = _binding!!
//
//override fun onCreateView(
//    inflater: LayoutInflater,
//    container: ViewGroup?,
//    savedInstanceState: Bundle?
//): View {
//    _binding = .inflate(inflater, container, false)
//    return binding.root
//}
//
//override fun onDestroyView() {
//    super.onDestroyView()
//    _binding = null
//}