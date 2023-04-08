package com.example.assignment_map

import android.util.Patterns
import java.util.regex.Pattern

class LoginUiData {


    private var email: String? = null
        set(value) {

            if (value != null) {
                field = value
            }
        }

    private var password: String? = null
        set(value) {

            if (value != null) {
                field = value
            }
        }

    constructor(email: String, password: String) {
        this.email = email
        this.password = password
    }

    val isValidEmail:Boolean
    get() = this.email!=null && this.email!!.isNotEmpty() && this.email!!.matches(Patterns.EMAIL_ADDRESS.toRegex())

    val isValidPassword:Boolean
    get() =  this.password!=null && this.password!!.isNotEmpty() && this.password!!.matches(".*[A-Z].*".toRegex()) &&
            this.password!!.matches(".*[a-z].*".toRegex()) && this.password!!.matches(".*[@#$%^&+=].*".toRegex())


}