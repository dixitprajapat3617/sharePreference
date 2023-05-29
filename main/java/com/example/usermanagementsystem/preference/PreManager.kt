package com.example.usermanagementsystem.preference

import android.content.Context
import android.content.Intent
import android.widget.RadioButton
import com.example.usermanagementsystem.RegistrationActivity

class PreManager(context: Context) {

    private val FILE_NAME = "User"
    private val KEY_NAME = "name"
    private val KEY_EMAIL = "email"
    private val KEY_PASSWORD = "password"
    private val KEY_CPASSWORD = "cPassword"
    private val KEY_GENDER = "gender"
    private val KEY_ISLOGIN = "login"
    private val KEY_DATE = "date"

    private val preference = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
    private val editor = preference.edit()

    fun registerUser(name: String, email: String, password: String, confirmPassword: String, gender:String, date:String) {
        editor.putString(KEY_NAME, name)
        editor.putString(KEY_EMAIL, email)
        editor.putString(KEY_PASSWORD, password)
        editor.putString(KEY_CPASSWORD, confirmPassword)
        editor.putString(KEY_DATE, date)
        editor.putString(KEY_GENDER, gender)
        editor.commit()
    }


    fun getName():String? {
        return preference.getString(KEY_NAME,null)
    }
    fun getDate():String? {
        return preference.getString(KEY_DATE,null)
    }

    fun getEmail(): String? {
        return preference.getString(KEY_EMAIL, null)
    }

    fun getPassword(): String? {
        return preference.getString(KEY_PASSWORD, null)
    }

    fun gender(status:String){
        editor.putString(KEY_GENDER, status)
        editor.commit()
    }

    fun getGender():String?{
        return preference.getString(KEY_GENDER,null)
    }

    fun updateLoginStatus(status:Boolean){
        editor.putBoolean(KEY_ISLOGIN, status)
        editor.commit()
    }

    fun update(name:String, email: String, gender:String, date:String){
        editor.putString(KEY_NAME,name)
        editor.putString(KEY_EMAIL,email)
        editor.putString(KEY_GENDER,gender)
        editor.putString(KEY_DATE,date)
        editor.commit()
    }

    fun delete(){
        editor.remove(KEY_ISLOGIN)
        editor.commit()
    }


}