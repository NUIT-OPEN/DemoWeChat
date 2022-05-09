package com.example.demowechat

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    lateinit var common_vars: CommonVariables

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        supportActionBar?.hide()
        common_vars = application as CommonVariables

        findViewById<ImageButton>(R.id.ib_exit).setOnClickListener {
            finish()
        }

        findViewById<Button>(R.id.b_login).setOnClickListener {
            val et_username = findViewById<EditText>(R.id.et_username)
            val et_password = findViewById<EditText>(R.id.et_password)
            login(et_username.text.toString(), et_password.text.toString())
        }

        findViewById<TextView>(R.id.tv_register).setOnClickListener {
            val intent = Intent()
            intent.setClass(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }

    fun login(username: String, password: String) {
        val user = common_vars.user
        user ?: run {
            Toast.makeText(this, getString(R.string.hint_register), Toast.LENGTH_SHORT).show()
            return
        }

        if (!user.username.equals(username) || !user.password.equals(password)) {
            Toast.makeText(this, getString(R.string.hint_info_mismatch), Toast.LENGTH_SHORT).show()
            return
        }

        Toast.makeText(
            this,
            String.format(getString(R.string.hint_login_success), user.username),
            Toast.LENGTH_SHORT
        ).show()

        val intent = Intent()
        intent.setClass(this, MainActivity::class.java)
        startActivity(intent)
    }
}
