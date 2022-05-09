package com.example.demowechat.model

import android.annotation.SuppressLint
import android.content.Context

class User(
    var username: String,
    var password: String,
    var gender: String,
    var birthday: String,
) {
    companion object {
        val SK_USER = "user"
        val EK_USERNAME = "username"
        val EK_PASSWORD = "password"
        val EK_GENDER = "gender"
        val EK_BIRTHDAY = "birthday"

        fun load(context: Context): User {
            val sp = context.getSharedPreferences(SK_USER, Context.MODE_PRIVATE)
            val username = sp.getString(EK_USERNAME, null)
            val password = sp.getString(EK_PASSWORD, null)
            val gender = sp.getString(EK_GENDER, null)
            val birthday = sp.getString(EK_BIRTHDAY, null)

            username.let {
                return User(
                    username.toString(),
                    password.toString(),
                    gender.toString(),
                    birthday.toString()
                )
            }
        }
    }

    @SuppressLint("CommitPrefEdits")
    fun save(context: Context) {
        val sp = context.getSharedPreferences(SK_USER, Context.MODE_PRIVATE)
        val editor = sp.edit()
        editor.putString(EK_USERNAME, username)
        editor.putString(EK_PASSWORD, password)
        editor.putString(EK_GENDER, gender)
        editor.putString(EK_BIRTHDAY, birthday)
        editor.apply()
    }
}