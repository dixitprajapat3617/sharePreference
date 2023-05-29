package com.example.usermanagementsystem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.usermanagementsystem.databinding.ActivityHomeBinding
import com.example.usermanagementsystem.preference.PreManager

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val manager = PreManager(this)

        supportActionBar?.title = "Dashboard"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.tvName.text = "Name: ${manager.getName()}"
        binding.tvEmail.text = "Email: ${manager.getEmail()}"
        binding.tvGender.text = "Gender: ${manager.getGender()}"
        binding.tvDate.text = "D.O.B. ${manager.getDate()}"

        binding.btnUpdate.setOnClickListener {
            startActivity(Intent(this,UpdateActivity::class.java))
        }

        binding.btnDelete.setOnClickListener {
            val manager = PreManager(this)
            manager.delete()
            startActivity(Intent(this,LoginActivity::class.java))
            finishAffinity()
        }
    }
}