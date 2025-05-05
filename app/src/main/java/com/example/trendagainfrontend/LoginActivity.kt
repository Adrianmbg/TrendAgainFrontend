package com.example.trendagainfrontend

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.trendagainfrontend.data.data.api.RetrofitClient
import com.example.trendagainfrontend.data.data.model.UserLoginRequest
import com.example.trendagainfrontend.ui.theme.AuthHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class LoginActivity : AppCompatActivity() {
    private lateinit var authHelper: AuthHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        authHelper = AuthHelper(this)

        btnLogin.setOnClickListener {
            val email = etEmail.text.toString()
            val password = etPassword.text.toString()

            GlobalScope.launch(Dispatchers.Main) {
                try {
                    val response = RetrofitClient.instance.loginUser(
                        UserLoginRequest(email, password)
                    )
                    if (response.isSuccessful) {
                        val authResponse = response.body()!!
                        authHelper.saveToken(authResponse.token)
                        startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                    } else {
                        Toast.makeText(this@LoginActivity, "Credenciales incorrectas", Toast.LENGTH_SHORT).show()
                    }
                } catch (e: Exception) {
                    Toast.makeText(this@LoginActivity, "Error: ${e.message}", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}