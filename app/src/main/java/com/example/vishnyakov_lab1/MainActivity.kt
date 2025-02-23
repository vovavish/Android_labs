package com.example.vishnyakov_lab1

import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val etUsername = findViewById<EditText>(R.id.etUsername)
        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val etConfirmPassword = findViewById<EditText>(R.id.etConfirmPassword)
        val btnRegister = findViewById<Button>(R.id.btnRegister)

        val tvUsernameError = findViewById<TextView>(R.id.tvUsernameError)
        val tvEmailError = findViewById<TextView>(R.id.tvEmailError)
        val tvPasswordError = findViewById<TextView>(R.id.tvPasswordError)
        val tvConfirmPasswordError = findViewById<TextView>(R.id.tvConfirmPasswordError)

        btnRegister.setOnClickListener {
            val username = etUsername.text.toString().trim()
            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString()
            val confirmPassword = etConfirmPassword.text.toString()

            var isValid = true

            tvUsernameError.text = ""
            tvEmailError.text = ""
            tvPasswordError.text = ""
            tvConfirmPasswordError.text = ""

            tvUsernameError.visibility = TextView.GONE
            tvEmailError.visibility = TextView.GONE
            tvPasswordError.visibility = TextView.GONE
            tvConfirmPasswordError.visibility = TextView.GONE

            if (username.isEmpty()) {
                tvUsernameError.text = "Username не может быть пустым"
                tvUsernameError.visibility = TextView.VISIBLE
                isValid = false
            }

            if (email.isEmpty()) {
                tvEmailError.text = "Email не может быть пустым"
                tvEmailError.visibility = TextView.VISIBLE
                isValid = false
            } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                tvEmailError.text = "Email невалидный"
                tvEmailError.visibility = TextView.VISIBLE
                isValid = false
            }

            if (password.isEmpty()) {
                tvPasswordError.text = "Пароль не может быть пустым"
                tvPasswordError.visibility = TextView.VISIBLE
                isValid = false
            } else if (password.length < 8) {
                tvPasswordError.text = "Пароль должен содержать минимум 8 символов"
                tvPasswordError.visibility = TextView.VISIBLE
                isValid = false
            }

            if (confirmPassword.isEmpty()) {
                tvConfirmPasswordError.text = "Пароль не может быть пустым"
                tvConfirmPasswordError.visibility = TextView.VISIBLE
                isValid = false
            } else if (confirmPassword != password) {
                tvConfirmPasswordError.text = "Пароли должны совпадать"
                tvConfirmPasswordError.visibility = TextView.VISIBLE
                isValid = false
            }

            if (isValid) {
                Toast.makeText(this, "Регистрация успешна!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
