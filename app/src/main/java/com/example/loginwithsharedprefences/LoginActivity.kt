package com.example.loginwithsharedprefences

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.loginwithsharedprefences.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val sharedPref = getSharedPreferences("sefa", MODE_PRIVATE)

        binding.btnLogin.setOnClickListener {

            val username = binding.edUsername.text.toString()
            val password = binding.edPassword.text.toString()


            val editor = sharedPref.edit()
            editor.putString("USERNAME", username)
            editor.putString("PASSWORD", password)
            editor.apply()

            if (username != "" && password != "") {
                val i = Intent(this, HomeActivity::class.java)
                startActivity(i)
            } else {
                Toast.makeText(this,"Kullanıcı adı ya da Şifre boş olamaz!",Toast.LENGTH_SHORT).show()
            }
        }

    }
}