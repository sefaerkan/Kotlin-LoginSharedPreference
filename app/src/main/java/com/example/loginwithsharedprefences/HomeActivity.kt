package com.example.loginwithsharedprefences

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.loginwithsharedprefences.databinding.ActivityHomeBinding
import com.example.loginwithsharedprefences.databinding.ActivityLoginBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val sharedPref = getSharedPreferences("sefa", MODE_PRIVATE)

        val username = sharedPref.getString("USERNAME", "").toString()
        val password = sharedPref.getString("PASSWORD", "").toString()
        binding.tvDisplay.text = "Username: $username Password: $password"
    }
}