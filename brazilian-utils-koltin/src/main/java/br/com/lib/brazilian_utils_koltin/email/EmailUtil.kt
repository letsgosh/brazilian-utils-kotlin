package br.com.lib.brazilian_utils_koltin.email

import android.util.Patterns

object EmailUtil {

    fun isValidateEmail(email: String)=
        Patterns.EMAIL_ADDRESS.matcher(email).matches()
}