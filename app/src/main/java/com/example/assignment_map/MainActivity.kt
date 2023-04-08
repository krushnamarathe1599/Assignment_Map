package com.example.assignment_map

import android.content.Intent
import android.content.res.ColorStateList
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.lifecycleScope
import com.example.assignment_map.databinding.ActivityMainBinding
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.combine
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {


    private var binding: ActivityMainBinding? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        supportActionBar?.hide()

        binding!!.loginButton.setOnClickListener {
            val loginUiData = LoginUiData(
                email = binding!!.edEmail.text.toString(),
                password = binding!!.edPassword.text.toString()
            )

            // First it will validate email and then validate password. If both are correct it will enable
            // login button and redirected to second activity otherwise it will disable the login button.
            if (loginUiData.isValidEmail && loginUiData.isValidPassword) {

                binding!!.loginButton.isEnabled = true
                Toast.makeText(this, "Validation Successful", Toast.LENGTH_SHORT).show()
                val intent = Intent(this@MainActivity, MapActivity::class.java)
                val emailSend = binding!!.edEmail.text.toString()
                intent.putExtra("email", emailSend)
                startActivity(intent)


            } else {
                if (!loginUiData.isValidEmail) {
                    binding!!.edEmail.error = "Invalid Email"

                    if (!loginUiData.isValidPassword) {
                        binding!!.edPassword.error = "Invalid Password"

                    }
                    binding!!.loginButton.isEnabled = false
                    Toast.makeText(this, "Invalid Credentials", Toast.LENGTH_SHORT).show()
                }

            }
        }


    }

    override fun onDestroy() {
        binding = null
        super.onDestroy()
    }

}


