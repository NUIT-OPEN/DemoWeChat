package com.example.demowechat

import android.app.Application
import com.example.demowechat.model.User

class CommonVariables : Application() {
    var user: User? = null

    override fun onCreate() {
        super.onCreate()
        user = User.load(this)
    }
}
