package com.example.demowechat

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.demowechat.model.User

class RegisterActivity : AppCompatActivity() {
    lateinit var common_vars: CommonVariables

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        supportActionBar?.hide()
        common_vars = application as CommonVariables

        findViewById<ImageButton>(R.id.ib_exit).setOnClickListener {
            finish()
        }

        val et_username = findViewById<EditText>(R.id.et_username)
        val et_password = findViewById<EditText>(R.id.et_password)
        val et_password_repeat = findViewById<EditText>(R.id.et_password_repeat)
        val rg_gender = findViewById<RadioGroup>(R.id.rg_gender)
        val etd_birthday = findViewById<EditText>(R.id.etd_birthday)
        val cb_accept = findViewById<CheckBox>(R.id.cb_accept)

        etd_birthday.setOnClickListener {
            val dialog = DatePickerDialog(this)
            dialog.setOnDateSetListener { view, year, month, dayOfMonth ->
                etd_birthday.setText(String.format("%d-%d-%d", year, month, dayOfMonth))
            }
            dialog.show()
        }

        findViewById<Button>(R.id.b_register).setOnClickListener {
            val rb_gender = findViewById<RadioButton>(rg_gender.checkedRadioButtonId)
            var gender: String? = null
            rb_gender?.let { gender = rb_gender.text.toString() }

            if (cb_accept.isChecked.not()) {
                Toast.makeText(this, getString(R.string.hint_accept_rules), Toast.LENGTH_SHORT)
                    .show()
            } else if (!et_password.text.toString().equals(et_password_repeat.text.toString())) {
                Toast.makeText(this, getString(R.string.hint_pwd_mismatch), Toast.LENGTH_SHORT)
                    .show()
            } else if (gender.toString().equals("null")) {
                Toast.makeText(this, getString(R.string.hint_no_gender), Toast.LENGTH_SHORT)
                    .show()
            } else if (et_username.text.isEmpty() || et_password.text.isEmpty() || etd_birthday.text.isEmpty()) {
                Toast.makeText(this, getString(R.string.hint_no_complete), Toast.LENGTH_SHORT)
                    .show()
            } else {
                register(
                    User(
                        et_username.text.toString(),
                        et_password.text.toString(),
                        gender.toString(),
                        etd_birthday.text.toString(),
                    )
                )
            }
        }
    }

    fun register(user: User) {
        common_vars.user = user
        user.save(this)
        Toast.makeText(this, getString(R.string.hint_register_success), Toast.LENGTH_SHORT).show()
        finish()
    }
}