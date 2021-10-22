package com.app

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.SharedPreferences

@SuppressLint("CommitPrefEdits")
class SharedPreferencesHelper(context: Context) {
    private val PREFS_NAME = "sharedpreflogin"
    private var sharedPref: SharedPreferences
    private val editor: SharedPreferences.Editor

    init {
        sharedPref = context.getSharedPreferences(PREFS_NAME,Context.MODE_PRIVATE)
        editor = sharedPref.edit()
    }
    fun put (key: String, value: String){
        editor.putString(key,value)
            .apply()
    }
    fun getString(key: String): String? {
        return sharedPref.getString(key,null)
    }
    fun put (key: String, value: Boolean){
        editor.putBoolean(key,value)
            .apply()
    }
    fun getBoolean(key: String): Boolean {
        return sharedPref.getBoolean(key,false)
    }
    fun clear(){
        editor.clear().apply()
    }
}