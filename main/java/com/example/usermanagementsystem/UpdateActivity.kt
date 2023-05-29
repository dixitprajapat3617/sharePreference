package com.example.usermanagementsystem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast

import com.example.usermanagementsystem.databinding.ActivityUpdateBinding
import com.example.usermanagementsystem.preference.PreManager

class UpdateActivity : AppCompatActivity() {
    lateinit var binding: ActivityUpdateBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "Update"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val manager = PreManager(this)

        binding.etName.setText(manager.getName())
        binding.etEmail.setText(manager.getEmail())
        binding.etDate.setText(manager.getDate())

        binding.btnUpdate.setOnClickListener {
            val name = binding.etName.text.toString().trim()
            val email = binding.etEmail.text.toString().trim()
            val date = binding.etDate.text.toString().trim()
            val gender = binding.checkRadio.setOnCheckedChangeListener { radioGroup, i ->
                if(R.id.radio_male == i) "Male" else "Female"
            }
            updateUser(name, email,gender,date)
        }


    }

    private fun updateUser(name: String, email: String, gender: Unit, date:String) {
        val manager = PreManager(this)
        manager.update(name,email, gender.toString(),date)

        startActivity(Intent(this, HomeActivity::class.java))
        Toast.makeText(this, "Update Success", Toast.LENGTH_SHORT).show()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item)
        onBackPressedDispatcher.onBackPressed()
    }
}