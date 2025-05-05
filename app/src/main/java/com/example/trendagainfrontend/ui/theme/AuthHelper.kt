package com.example.trendagainfrontend.ui.theme

import android.content.Context
import android.content.SharedPreferences

class AuthHelper(private val context: Context) {
    private val sharedPref: SharedPreferences =
        context.getSharedPreferences("TrendAgainPrefs", Context.MODE_PRIVATE)

    fun saveToken(token: String) {
        sharedPref.edit().putString("JWT_TOKEN", token).apply()
    }

    fun getToken(): String? {
        return sharedPref.getString("JWT_TOKEN", null)
    }

    fun clearToken() {
        sharedPref.edit().remove("JWT_TOKEN").apply()
    }
}