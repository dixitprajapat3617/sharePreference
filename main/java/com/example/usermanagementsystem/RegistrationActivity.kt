package com.example.usermanagementsystem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.usermanagementsystem.databinding.ActivityRegistrationBinding
import com.example.usermanagementsystem.preference.PreManager

class RegistrationActivity : AppCompatActivity() {
    lateinit var binding: ActivityRegistrationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "Registration"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.btnSignUp.setOnClickListener {
            val name = binding.etName.text.toString().trim()
            val email = binding.etEmail.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()
            val cPassword = binding.etConfirm.text.toString().trim()
            val date = binding.etDate.text.toString().trim()
            var gender = binding.checkRadio.setOnCheckedChangeListener { radioGroup, i ->
                if(R.id.radio_male == i) "Male" else "Female"
            }
            register(name,email,password,cPassword, gender, date)
        }
    }

    private fun register(name: String, email: String, password: String, cPassword: String, gender: Unit, date:String) {
        val manager = PreManager(this)
        manager.registerUser(name,email,password,cPassword, gender.toString(),date)

        startActivity(Intent(this, LoginActivity::class.java))
        Toast.makeText(this, "Registration Success", Toast.LENGTH_SHORT).show()
    }
}